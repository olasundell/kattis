import java.util.Scanner;
import kotlin.math.min

/**
 * TODO write documentation
 */
class KeyToCrypto {
    fun solve(scanner: Scanner): String {
        val line = scanner.next().map { it - 'A' }
        val key = scanner.next().map { it - 'A' }

        val result = mutableListOf<Int>()

        (0 until min(key.size, line.size)).forEach { i ->
            val it = (26 + line[i] - key[i]) % 26
            result.add(it)
        }

        for (i in (key.size) until line.size) {
            val it = (26 + line[i] - result[i - (key.size)]) % 26
            result.add(it)
        }

        return result.map { it + 'A'.toInt() }.map { it.toChar() }.joinToString(separator="")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(KeyToCrypto().solve(scanner))
}