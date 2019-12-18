package kattis

import java.util.*

/**
 * TODO write documentation
 */
class BubbleTea {
    fun solve(scanner: Scanner): String {
        val teas = mutableMapOf<Int, Tea>()
        val toppings = mutableMapOf<Int, Topping>()

        val noOfTeas = scanner.nextInt()

        for (i in 1..noOfTeas) {
            teas.put(i, Tea(scanner.nextInt()))
        }

        val noOfToppings = scanner.nextInt()

        for (i in 1..noOfToppings) {
            toppings.put(i, Topping(scanner.nextInt()))
        }

        for (i in 1..noOfTeas) {
            val n = scanner.nextInt()
            for (j in 1..n) {
                toppings[scanner.nextInt()]?.let { teas[i]?.addTopping(it) }
            }
        }

        val money = scanner.nextInt()

        return Math.max(0, ((money / teas.values.toSortedSet().first().price()).toInt() - 1)).toString()
    }

    class Tea(val price: Int): Comparable<Tea> {
        private val toppings = mutableListOf<Topping>()

        override fun compareTo(other: Tea): Int {
            return this.price() - other.price()
        }

        fun price(): Int {
            return this.price + toppings.toSortedSet().first().price
        }

        fun addTopping(t: Topping) {
            toppings.add(t)
        }
    }

    data class Topping(val price: Int): Comparable<Topping> {
        override fun compareTo(other: Topping): Int {
            return this.price - other.price
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(BubbleTea().solve(scanner))
}