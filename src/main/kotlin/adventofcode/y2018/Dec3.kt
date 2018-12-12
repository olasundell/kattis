package adventofcode.y2018;

import java.util.*

class Dec3 {
    fun solve(scanner: Scanner): String {
        val claims = readClaims(scanner)
        val matrix = map(claims)

        return scanForOverclaims(matrix)
    }

    fun solve2(scanner: Scanner): String {
        val claims = readClaims(scanner)
        val matrix = map(claims)

        for (claim in claims) {
            if (matrix.filterValues { v -> v.contains(claim) }.filterValues { v -> v.size > 1 }.size == 0) {
                return claim.num.toString()
            }
        }

        return "-1"
    }


    private fun readClaims(scanner: Scanner): List<Claim> {
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
        }

        return claims
    }

    private fun map(claims: List<Claim>): Map<Pair<Int, Int>, List<Claim>> {
        val map = mutableMapOf<Pair<Int, Int>, List<Claim>>()

        for (claim in claims) {
            for (i in claim.start.first until claim.end.first) {
                for (j in claim.start.second until claim.end.second) {
                    map.compute(Pair(i, j)) { _: Pair<Int, Int>, u: List<Claim>? -> u?.plus(claim) ?: listOf(claim) }
                }
            }
        }

        return map
    }

    private fun scanForOverclaims(matrix: Map<Pair<Int, Int>, List<Claim>>): String {
        var overclaims = 0
        for (i in matrix) {
            if (i.value.size > 1) {
                overclaims++
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