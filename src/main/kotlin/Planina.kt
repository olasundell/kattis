import java.util.*

/**
 * TODO write documentation
 */
class Planina {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        var c = 2

        for (i in 1..n) {
            c += c - 1
        }

        val sum = c * c

        return sum.toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Planina().solve(scanner))
}
