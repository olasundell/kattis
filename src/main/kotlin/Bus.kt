import java.util.Scanner;
import kotlin.math.pow

/**
 * TODO write documentation
 */
class Bus {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val result = mutableListOf<Int>()

        repeat(n) {
            val i = scanner.nextInt()
            if (i == 1) {
                result.add(1)
            } else {
                result.add(1 + (1 until i).map { 2.0.pow(it).toInt() }.sum())
            }
        }

        return result.joinToString(separator="\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Bus().solve(scanner))
}