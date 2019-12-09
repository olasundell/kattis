import java.util.Scanner;

/**
 * TODO write documentation
 */
class LuhnChecksum {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()

        val result = mutableListOf<String>()

        while (scanner.hasNext()) {
            result += validate(scanner.next())
        }

        return result.joinToString(separator = "\n")
    }

    private fun validate(line: String): String {
        var sum = 0
        var odd = true
        for (c in line.reversed()) {
            val d = c - '0'

            if (odd) {
                sum += d
            } else {
                sum += checksum(d)
            }
            odd = !odd
        }
        return if (sum % 10 == 0) {
            "PASS"
        } else {
            "FAIL"
        }
    }

    private fun checksum(d: Int): Int {
        val d2 = d * 2
        return if (d2 > 9) {
            (d2 / 10) + (d2 % 10)
        } else {
            d2
        }
    }

}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(LuhnChecksum().solve(scanner))
}