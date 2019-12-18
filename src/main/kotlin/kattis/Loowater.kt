package kattis

import java.util.*

/**
 * TODO write documentation
 */
class Loowater {
    fun solve(scanner: Scanner): String {
        val results = mutableListOf<Int>()
        while (true) {
            val noOfDragons = scanner.nextInt()
            val noOfKnights = scanner.nextInt()
            val headsUnsorted = mutableListOf<Int>()
            val knightsUnsorted = mutableListOf<Int>()

            if (noOfDragons == 0 && noOfKnights == 0) {
                break;
            }

            for (i in 0 until noOfDragons) {
                headsUnsorted.add(scanner.nextInt())
            }

            for (i in 0 until noOfKnights) {
                knightsUnsorted.add(scanner.nextInt())
            }

            if (noOfDragons > noOfKnights) {
                results.add(-1)
            } else {
                headsUnsorted.sort()
                results.add(calc(headsUnsorted, knightsUnsorted))
            }
        }

        return results.joinToString(separator = "\n") { i -> if (i == -1) "kattis.Loowater is doomed!" else i.toString() }
    }

    private fun calc(dragons: List<Int>, knights: List<Int>): Int {
        val kMap = mutableMapOf<Int, Int>()
        for (k in knights) {
            kMap.merge(k, 1) { old, _ -> old + 1 }
        }

        val knightMap: SortedMap<Int, Int> = kMap.toSortedMap()
        var cost = 0

        for (d in dragons) {
            val tail = knightMap.tailMap(d)
            if (tail.isEmpty()) {
                return -1
            }

            val height = tail.firstKey()
            val noAtCurrentHeight = knightMap[height]

            cost += height

            if (noAtCurrentHeight == 1) {
                knightMap.remove(height)
            } else {
                // it won't be null, trust me
                if (noAtCurrentHeight != null) {
                    knightMap[height] = noAtCurrentHeight.minus(1)
                }
            }
        }

        return cost
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Loowater().solve(scanner))
}