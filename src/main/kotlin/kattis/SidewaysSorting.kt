package kattis

import java.util.Scanner;
import kotlin.IllegalArgumentException

/**
 * TODO write documentation
 */
class SidewaysSorting {
    fun solve(scanner: Scanner): String {
        var rows: Int
        var noOfCols: Int

        val results = mutableListOf<Result>()

        do {
            rows = scanner.nextInt()
            noOfCols = scanner.nextInt()
            scanner.nextLine()

            val cols = mutableListOf<ComparableList>()
            for (i in 1..noOfCols) {
                cols.add(ComparableList())
            }

            for (i in 0 until rows) {
                val line = scanner.nextLine()
                for (j in 0 until noOfCols) {
                    cols.get(j).add(CChar(line[j], j))
                }

//                lines.add(line.mapIndexed{ pos, c -> CChar(c, pos) }.sorted().toList())
            }

            if (cols.isNotEmpty()) {
                results.add(Result(cols.sorted()))
            }
        } while (rows > 0)

        return results.joinToString(separator = "\n\n")
    }

    class ComparableList: ArrayList<CChar>(), Comparable<ComparableList> {
        override fun compareTo(other: ComparableList): Int {
            if (this.size != other.size) {
                throw IllegalArgumentException("$other doesn't have the same length as ${this}")
            }

            for (i in 0 until this.size) {
                val compareTo = this[i].char.toLowerCase().compareTo(other[i].char.toLowerCase())
                if (compareTo != 0) {
                    return compareTo
                }
            }

            for (i in 0 until this.size) {
                val compareTo = this[i].pos.compareTo(other[i].pos)
                if (compareTo != 0) {
                    return compareTo
                }
            }

            return 0
        }

    }

    data class Result(val cols: List<List<CChar>>) {
        override fun toString(): String {
            if (cols.isEmpty()) {
                return ""
            }
            val sb = StringBuilder()

            for (i in 0 until cols[0].size) {
                for (j in 0 until cols.size) {
                    sb.append(cols[j][i])
                }

                if (i < cols[0].size - 1) {
                    sb.append('\n')
                }
            }
//            return lines.map{ l -> l.joinToString(separator = "") }.joinToString(separator = "\n")
            return sb.toString()
        }
    }

    data class CChar(val char: Char, val pos: Int) {
        override fun toString(): String {
            return "$char"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(SidewaysSorting().solve(scanner))
}