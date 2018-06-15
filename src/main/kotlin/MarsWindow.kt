import java.time.LocalDate
import java.util.Scanner;

/**
 * TODO write documentation
 */
class MarsWindow {
    fun solve(scanner: Scanner): String {
        val n = (scanner.nextInt() - 2018) * 12 - 4;

        for (i in 1..12) {
            if ((n + i) % 26 == 0) {
                return "yes"
            }
        }

        return "no"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(MarsWindow().solve(scanner))
}