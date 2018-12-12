package adventofcode.y2018;

import java.lang.System.out
import java.util.*

class Dec7(val timePad: Int, val queueSize: Int) {
    fun solve(scanner: Scanner): String {
        val down = mutableMapOf<Char, MutableSet<Char>>()
        val up = mutableMapOf<Char, MutableSet<Char>>()

        while (scanner.hasNextLine()) {
            // Step C must be finished before step A can begin.
            val line = scanner.nextLine()
            addOne(line, down, up)
        }

        return constructLine(down, up)
    }

    private fun constructLine(down: MutableMap<Char, MutableSet<Char>>, up: MutableMap<Char, MutableSet<Char>>): String {
        val set: SortedSet<Char> = findRoots(down, up)
        var result = ""

        while (set.isNotEmpty()) {
            for (c in set) {
                if (!up.containsKey(c) || up[c]!!.isEmpty()) {
                    result += c
                    out.println(c)
                    break
                }
            }

            removeElementAndUpdateSet(set, down, up, result.last())
        }

        return result
    }

    private fun removeElementAndUpdateSet(set: SortedSet<Char>, down: MutableMap<Char, MutableSet<Char>>, up: MutableMap<Char, MutableSet<Char>>, element: Char) {
        if (set.isNotEmpty()) {
            set.remove(element)
        }
        down[element]?.forEach {
            up[it]?.remove(element)
        }
        set.addAll(down[element] ?: listOf())
        down.remove(element)
        up.remove(element)
    }

    private fun findRoots(down: Map<Char, Set<Char>>, up: Map<Char, Set<Char>>): SortedSet<Char> {
        val not = down.filterNot { up.containsKey(it.key) }.keys
        return not.toSortedSet()
    }

    private fun addOne(line: String, down: MutableMap<Char, MutableSet<Char>>, up: MutableMap<Char, MutableSet<Char>>): Char {
        val parent = line[5]
        val child = line[36]
        down.computeIfAbsent(parent) { mutableSetOf() }.add(child)
        up.computeIfAbsent(child) { mutableSetOf() }.add(parent)

        return parent
    }

    fun solve2(scanner: Scanner): String {
        val down = mutableMapOf<Char, MutableSet<Char>>()
        val up = mutableMapOf<Char, MutableSet<Char>>()

        while (scanner.hasNextLine()) {
            // Step C must be finished before step A can begin.
            val line = scanner.nextLine()
            addOne(line, down, up)
        }

        val workers = sortedMapOf<Int, Char>()
        val set = findRoots(down, up)

        var result = ""
        var currentTime = -1

        populateWorkers(workers, set, currentTime, up)

        for (i in 0..Int.MAX_VALUE) {
            printState(i, workers, result)

            if (workers.isEmpty() || i > 1_000_000) {
                out.println(result)
                return i.toString()
            }

            while (workers.isNotEmpty() && workers.firstKey() == i) {
                val k = workers.firstKey()
                val c = workers[k]!!
                workers.remove(k)
                result += c
                removeElementAndUpdateSet(set, down, up, c)
                populateWorkers(workers, set, i, up)
            }

        }

        return currentTime.toString()
    }

    private fun printState(currentTime: Int, workers: SortedMap<Int, Char>, result: String) {
        out.println("${currentTime.toString().padStart(5, ' ')} ${workers.values.joinToString(" ").padEnd(10, ' ')} $result")
    }

    private fun populateWorkers(workers: SortedMap<Int, Char>, set: SortedSet<Char>, currentTime: Int, up: MutableMap<Char, MutableSet<Char>>) {
        val iterator = set.filterNot { workers.values.contains(it) }.iterator()

        var i = workers.size

        while (i < Math.min(queueSize, set.size) && iterator.hasNext()) {
            val c = iterator.next()
            if (!up.containsKey(c) || up[c]!!.isEmpty()) {
                val time = timePad + (c - 'A' + 1) + currentTime
                workers[time] = c
                i++
            }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec7(-1, -1).solve(scanner))
}