import java.util.Scanner;

/**
 * TODO write documentation
 */
class WhichBase {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val results = mutableListOf<List<Int>>()

        for (i in 0 until n) {
            // ignore index
            scanner.nextInt()
            val q = scanner.next()

            val oct = try {
                q.toInt(8)
            } catch (e: IllegalArgumentException) {
                0
            }

            val dec = q.toInt(10)
            val hex = q.toInt(16)

            results.add(listOf(oct, dec, hex))
        }

        return results.mapIndexed { i, l -> "${i + 1} ${l.joinToString(separator = " ")}" }.joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(WhichBase().solve(scanner))
}