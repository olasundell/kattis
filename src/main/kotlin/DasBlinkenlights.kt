import java.util.Scanner;

/**
 * TODO write documentation
 */
class DasBlinkenlights {
    fun solve(scanner: Scanner): String {
        val a = scanner.nextInt()
        val b = scanner.nextInt()
        val time = scanner.nextInt()
        val lcm = (a * b) / gcd(a, b)
        return if (time >= lcm) {
            "yes"
        } else {
            "no"
        }
    }

    private fun gcd(first: Int, second: Int): Int {
        var a = first
        var b = second

        while (b != 0) {
            val t = b
            b = a % b
            a = t
        }

        return a
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(DasBlinkenlights().solve(scanner))
}