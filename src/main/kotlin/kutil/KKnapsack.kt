package kutil

import java.math.BigInteger
import java.text.MessageFormat
import java.util.*
import java.util.function.BiFunction
import java.util.function.Consumer
import java.util.stream.Collectors

/**
 * Unbounded knapsack solver
 */
object KKnapsack {
    /**
     * Solves the unbounded knapsack problem for a given collection of items.
     *
     * @param items available items
     * @param capacity knapsack capacity (total)
     */
    fun solve(items: List<Item>, capacity: Int): Solution {
        val normFactor: Int = calculateNormalizationFactor(items, capacity)
        val normItems: List<Item> = normalizedItemsCopy(items, normFactor)
        val normCapacity: Int = capacity / normFactor
        val solution: Solution = dynamicProgrammingSolution(normItems, normCapacity)

        return denormalizedSolution(solution, normFactor)
    }

    /**
     * Dynamic programming implementation based on [Rosetta Code](http://rosettacode.org/wiki/Knapsack_problem/Unbounded/Python_dynamic_programming#DP.2C_single_size_dimension).
     */
    private fun dynamicProgrammingSolution(itemsUnsorted: List<Item>, capacity: Int): Solution {
        val items = itemsUnsorted.sortedWith { i1: Item, i2: Item -> (i2.valueToSizeRatio.compareTo(i1.valueToSizeRatio)) }

        //Keeps track of current sack value for given capacity
        val sackValues = IntArray(capacity + 1)

        //Keeps track of items that "completed" a given capacity. That is, lastItem[c] is the index of the item, that was
        //most recently added to the sack with capacity 'c'
        val lastItem = IntArray(capacity + 1)

        //There is no "last item" in a given capacity by default. We'll be using a negative index to distinguish this
        //case (clarity).
        Arrays.fill(lastItem, -1)
        for (i in items.indices) {
            val item: Item = items[i]
            val size: Int = item.size
            val value: Int = item.value
            for (c in size..capacity) {
                val trial: Int = sackValues[c - size] + value
                if (sackValues[c] < trial) {
                    sackValues[c] = trial
                    lastItem[c] = i
                }
            }
        }
        val baggedItems: MutableList<BaggedItem> = ArrayList()
        val counters: IntArray = collectItemCounters(items, capacity, lastItem)
        for (i in items.indices) {
            baggedItems.add(BaggedItem(items[i], counters[i]))
        }
        return Solution(Collections.unmodifiableCollection(baggedItems))
    }

    /**
     * A helper method for the dynamic programming solution, which maps the lastItem array to an array of counters.
     */
    private fun collectItemCounters(items: List<Item>, capacity: Int, lastItem: IntArray): IntArray {
        val counters = IntArray(items.size)
        var c: Int = capacity
        while (c > 0) {
            var itemIndex: Int = lastItem[c]

            //If no item was added in this capacity, move to the previous one.
            while (itemIndex < 0 && c > 0) {
                c--
                itemIndex = lastItem[c]
            }

            //If an item was found, increment it's counter and move "down" by current item size.
            if (itemIndex >= 0 && c > 0) {
                counters[itemIndex]++
                c -= items[itemIndex].size
            }
        }
        return counters
    }

    /**
     * Calculates the normalization factor for input data (to save memory during dp iterations)
     */
    private fun calculateNormalizationFactor(items: List<Item>, capacity: Int): Int {
        val gcd: BiFunction<Int, Int, Int> =
            BiFunction { a: Int, b: Int -> BigInteger.valueOf(a.toLong()).gcd(BigInteger.valueOf(b.toLong())).toInt() }
        return items.map { item: Item ->
            if (item.size == 0) capacity else gcd.apply(
                item.size,
                capacity
            )
        }.reduce { a: Int, b: Int -> Integer.min(a, b) }
    }

    /**
     * Creates a normalized copy of input items.
     */
    private fun normalizedItemsCopy(items: List<Item>, normFactor: Int): List<Item> {
        val normItems: MutableList<Item> = ArrayList(items.size)
        for (i: Item in items) {
            normItems.add(Item(i.name, i.value, i.size / normFactor))
        }
        return normItems
    }

    /**
     * Creates a denormalized copy of the solution.
     */
    private fun denormalizedSolution(solution: Solution, normFactor: Int): Solution {
        val denormItems: List<BaggedItem> = solution.baggedItems.stream().map { baggedItem: BaggedItem ->
            val item: Item = baggedItem.item
            BaggedItem(Item(item.name, item.value, item.size * normFactor), baggedItem.counter)
        }.collect(Collectors.toList())
        return Solution(Collections.unmodifiableCollection(denormItems))
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val scanner: Scanner = Scanner(System.`in`)
        val capacity: Int = scanner.nextInt()
        val items: MutableList<Item> = ArrayList()
        while (scanner.hasNextLine()) {
            val line: String = scanner.nextLine()
            if (line.trim { it <= ' ' }.isEmpty()) {
                continue
            }
            val fields: Array<String> = line.split(",").toTypedArray()
            items.add(Item(fields[0], fields[2].toInt(), fields[1].toInt()))
        }
        val solution: Solution = solve(items, capacity)
        solution.baggedItems.forEach(Consumer { bi: BaggedItem ->
            println(
                MessageFormat.format(
                    "{0},{1,number,#},{2,number,#},{3,number,#}",
                    bi.item.name,
                    bi.counter,
                    bi.totalSize,
                    bi.totalValue
                )
            )
        })
        println(MessageFormat.format("{0,number,#},{1,number,#}", solution.totalSize, solution.totalValue))
    }

    /**
     * An item representation.
     */
    class Item(val name: String, val value: Int, val size: Int) {
        val valueToSizeRatio: Double
            get() = value.toDouble() / size.toDouble()
    }

    /**
     * An item in a knapsack
     */
    class BaggedItem internal constructor(val item: Item, val counter: Int) {
        val totalValue: Int
            get() = item.value * counter
        val totalSize: Int
            get() = item.size * counter
    }

    /**
     * Knapsack problem solution.
     */
    class Solution internal constructor(val baggedItems: Collection<BaggedItem>) {

        val totalValue: Int = baggedItems.map { obj: BaggedItem -> obj.totalValue }
            .reduce { a: Int, b: Int -> Integer.sum(a, b) }
        val totalSize: Int = baggedItems.map { obj: BaggedItem -> obj.totalSize }
            .reduce { a: Int, b: Int -> Integer.sum(a, b) }
        val totalItems: Int = baggedItems.map { obj: BaggedItem -> obj.counter }
            .reduce { a: Int, b: Int -> Integer.sum(a, b) }
    }
}