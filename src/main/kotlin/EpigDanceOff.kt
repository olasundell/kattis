import java.util.Scanner;

/**
 * TODO write documentation
 */
class EpigDanceOff {
    fun solve(scanner: Scanner): String {
        val rows = scanner.nextInt()
        val cols = scanner.nextInt()

        scanner.nextLine()

        val array: Array<Int> = Array(cols) { 0 }

        var i = 0

        for (y in 0 until rows) {
            val line = scanner.nextLine()
            for (x in line.indices) {
                if (line[x] == '_') {
                    array[x]++
                }
            }
        }

        return "${array.filter { it == rows }.size + 1}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(EpigDanceOff().solve(scanner))
}