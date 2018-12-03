package adventofcode.y2018;

import java.util.*

class Dec3 {
    fun solve(scanner: Scanner): String {
        val matrixSize = 1_000
        val matrix = Array(matrixSize) { Array(matrixSize) { 0 } }
        val claims = mutableListOf<Claim>()

        while (scanner.hasNext()) {
            val no = scanner.next().replace("#", "").toInt()
            val at = scanner.next()
            val point = scanner.next().replace(":", "").split(",")
            val size = scanner.next().split("x")

            val start = Pair(point[0].toInt(), point[1].toInt())
            val end = Pair(start.first + size[0].toInt(), start.second + size[1].toInt())
            val claim = Claim(no, start, end)
            claims.add(claim)
            fill(matrix, claim)
        }

        return scanForOverclaims(matrix)
    }

    private fun scanForOverclaims(matrix: Array<Array<Int>>): String {
        var overclaims = 0
        for (i in matrix) {
            for (j in i) {
                if (j > 1) {
                    overclaims++
                }
            }
        }

        return overclaims.toString()
    }

    private fun fill(matrix: Array<Array<Int>>, claim: Claim) {
        for (i in claim.start.first until claim.end.first) {
            for (j in claim.start.second until claim.end.second) {
                matrix[i][j]++
            }
        }
    }

    data class Claim(val num: Int, val start: Pair<Int, Int>, val end: Pair<Int, Int>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec3().solve(scanner))
}