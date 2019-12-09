import java.util.Scanner;

/**
 * TODO write documentation
 */
class Egypt {
    fun solve(scanner: Scanner): String {
        val results = mutableListOf<Boolean>()
        while (true) {
            val a = scanner.nextInt()
            val b = scanner.nextInt()
            val c = scanner.nextInt()

            if (a == 0 && b == 0 && c == 0) {
                break
            }

            results.add(calc(a, b, c))
        }

        return results.joinToString(separator = "\n") { if (it) "right" else "wrong" }
    }

    private fun calc(a: Int, b: Int, c: Int): Boolean {
        val list = listOf(a, b, c).sortedDescending()
        return list[0] * list[0] == list[1] * list[1] + list[2] * list[2]
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Egypt().solve(scanner))
}