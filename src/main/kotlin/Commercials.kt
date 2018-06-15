import java.util.Scanner;

/**
 * TODO write documentation
 */
class Commercials {
    fun solve(scanner: Scanner): String {
        val seq: MutableList<Int> = mutableListOf()

        val n = scanner.nextInt()
        val cost = scanner.nextInt()

        while (scanner.hasNextInt()) {
            seq.add(scanner.nextInt() - cost)
        }

        return kadane(seq).toString()
    }

    fun kadane(seq: List<Int>): Int {
        var maxSum = 0
        var sum = 0
        for (eachNumber in seq) {
            sum += eachNumber
            maxSum = Math.max(sum, maxSum)
            sum = Math.max(sum, 0)
        }
        return maxSum
    }

    fun gss(seq: List<Int>): Triple<Int, Int, Int> {
        if (seq.isEmpty()) throw IllegalArgumentException("Array cannot be empty")
        var sum: Int
        var maxSum = seq[0]
        var first = 0
        var last = 0
        for (i in 1 until seq.size) {
            sum = 0
            for (j in i until seq.size) {
                sum += seq[j]
                if (sum > maxSum) {
                    maxSum = sum
                    first = i
                    last = j
                }
            }
        }
        return Triple(maxSum, first, last)
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Commercials().solve(scanner))
}