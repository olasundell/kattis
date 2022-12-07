package adventofcode.y2020;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec7 {
    fun solve(scanner: Scanner): String {
        val map = mutableMapOf<String, Map<String, Int>>()
        val revMap = mutableMapOf<String, List<String>>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine().replace(".", "").split(" contain ")
            val contains = line[1].split(", ")

            val left = line[0].deS()
            map[left] = contains.filter { it.num() > 0 }.map { it.bag() to it.num() }.toMap()
            contains.filter { it.num() > 0 }.forEach { revMap[it.bag()] = revMap[it.bag()].orEmpty().plus(left) }
        }

        val list = revMap["shiny gold bag"].orEmpty()
//        val set = list.flatMap { countBags(revMap, it) }.toSet()
        val set = countUpwards(revMap, "shiny gold bag")
        return "${set.size}"
    }

    fun countUpwards(revMap: Map<String, List<String>>, s: String): Set<String> {
        return revMap[s].orEmpty().flatMap {
//            println(it)
            countUpwards(revMap, it).plus(it)
        }.toSet()
    }

    fun solve2(scanner: Scanner): String {
        val map = mutableMapOf<String, Map<String, Int>>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine().replace(".", "").split(" contain ")
            val contains = line[1].split(", ")

            val left = line[0].deS()
            map[left] = contains.filter { it.num() > 0 }.map { it.bag() to it.num() }.toMap()
        }

        return "${countBags(map, "shiny gold bag") - 1}"
    }

    fun countBags(map: Map<String, Map<String, Int>>, s: String): Long {
        if (map[s].orEmpty().isEmpty()) {
            println("$s is an end node")
            return 1
        }

        return map[s].orEmpty().map {
            countBags(map, it.key) * it.value
        }.sum() + 1
    }

    fun String.num() = if (this.startsWith("no")) { 0 } else { this[0] - '0' }
    fun String.bag() = this.substring(2).deS()
    fun String.deS() = this.replace("s$".toRegex(), "")
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec7().solve(scanner))
}