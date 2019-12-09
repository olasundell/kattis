import java.util.Scanner;

/**
 * TODO write documentation
 */
class HarshadNumbers {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        for (i in n..1_000_000_000) {
            val digiSum = digiSum(i)
            if (i % digiSum == 0) {
                return i.toString()
            }
        }
        return ""
    }

    private fun digiSum(i: Int): Int {
        var n = i
        var sum = 0

        while (n > 10) {
            sum += n % 10
            n /= 10
        }

        sum += n

        return sum
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(HarshadNumbers().solve(scanner))
}