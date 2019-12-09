package adventofcode.y2019;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec6 {
    fun solve(scanner: Scanner): String {
        val orbits = mutableMapOf<String, MutableSet<String>>()
        val orbRev = mutableMapOf<String, String>()
        val depth = mutableMapOf<String, Int>()

        while(scanner.hasNextLine()) {
            val parts = scanner.nextLine().split(")")

            orbits.putIfAbsent(parts[0], mutableSetOf())?.add(parts[1])
            orbRev[parts[1]] = parts[0]
        }

//        val c = count(orbits, "COM", 0)
//        return "$c"

        val you: Map<String, Int> = findRootChain(orbRev, "YOU", -1)
        val san: Map<String, Int> = findRootChain(orbRev, "SAN", -1)

        for (p in you.entries.sortedBy { entry -> entry.value }) {
            if (san.containsKey(p.key)) {
                return (p.value + san[p.key]!!).toString()
            }
        }

//        var p = -1
//        for (i in you.indices) {
//            if (sanSet.contains(you[i])) {
//                p = i
//            }
//        }

        return ""
    }

    private fun findRootChain(orbRev: Map<String, String>, s: String, i: Int): Map<String, Int> {
        if (orbRev[s].isNullOrEmpty()) {
            return mapOf(s to i)
        } else {
            return mapOf(s to i).plus(findRootChain(orbRev, orbRev[s]!!, i + 1))
        }
    }

    fun count(orbits: Map<String, Set<String>>, s: String, i: Int): Int {
        if (orbits[s].isNullOrEmpty()) {
            return i
        } else {
            return orbits[s]!!.map { count(orbits, it, i + 1) }.sum() + i
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec6().solve(scanner))
}