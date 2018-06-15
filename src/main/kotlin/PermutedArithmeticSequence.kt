import java.util.Scanner;

/**
 * TODO write documentation
 */
class PermutedArithmeticSequence {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val results = mutableListOf<String>()

        for (i in 1..n) {
            val l = scanner.nextInt()

            val list = mutableListOf<Int>()

            for (j in 1..l) {
                list.add(scanner.nextInt())
            }

            if (isArithmetic(list)) {
                results.add("arithmetic")
            } else {
                if (isArithmetic(list.sorted())) {
                    results.add("permuted arithmetic")
                } else {
                    results.add("non-arithmetic")
                }
            }
        }

        return results.joinToString(separator = "\n")
    }

    private fun isArithmetic(list: List<Int>): Boolean {
        val diff: Int = list[1] - list[0]

        var prev = list[0]
        var arithmetic = true

        for (k in list.subList(1, list.size)) {
            if (prev + diff != k) {
                arithmetic = false
                break;
            }

            prev = k
        }
        return arithmetic
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(PermutedArithmeticSequence().solve(scanner))
}