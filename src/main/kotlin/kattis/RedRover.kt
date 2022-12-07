package kattis;

import java.util.*

/**
 * TODO write documentation
 */
class RedRover {
    fun solve(scanner: Scanner): String {
        val line = scanner.nextLine()
        return ""
    }

    fun findLongestRepeatingSubSeq(str: String): Int {
        val n = str.length

        // Create and initialize DP table
        val dp = Array(n + 1) { IntArray(n + 1) }

        // Fill dp table (similar to LCS loops)
        for (i in 1..n) {
            for (j in 1..n) {
                // If characters match and indexes are not same
                if (str[i - 1] == str[j - 1] && i != j) dp[i][j] = 1 + dp[i - 1][j - 1] else dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j])
            }
        }
        return dp[n][n]
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(RedRover().solve(scanner))
}