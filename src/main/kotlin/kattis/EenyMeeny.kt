package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class EenyMeeny {
    fun solve(scanner: Scanner): String {
        val inc = scanner.nextLine().split(" ").size - 1
        val n = scanner.nextInt()
        val list = (1..n).map { scanner.next() }.toMutableList()

        val map = mutableMapOf<Boolean, MutableList<String>>()
        map[true] = mutableListOf()
        map[false] = mutableListOf()

        var idx = 0
        var f = true

        while (list.isNotEmpty()) {
            idx = (idx + inc) % list.size
            val s = list.removeAt(idx)
//            map.compute(f) { _: Boolean, u: List<String>? -> u?.kattis.plus(s) ?: listOf(s) }
            map[f]!!.add(s)
            f = !f
        }

        return stringify(map)
    }

    private fun stringify(map: MutableMap<Boolean, MutableList<String>>): String {
        val first = map[true]!!
        val second = map[false]!!

        val fs = "${first.size}\n" + first.joinToString(separator = "\n")
        val ss = "${second.size}\n" + second.joinToString(separator = "\n")

        return "$fs\n$ss"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(EenyMeeny().solve(scanner))
}