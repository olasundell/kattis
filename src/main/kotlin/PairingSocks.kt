import java.util.Scanner;

/**
 * TODO write documentation
 */
class PairingSocks {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()
        val socks = scanner.nextLine().split(" ").map { s -> s.toInt() }.toMutableList()

        var idx = 0
        var moves = 0

        while ( idx < socks.size ) {
            moves++

            if (idx > 0 && socks[idx] == socks[idx - 1]) {
                socks.removeAt(idx -1)
                socks.removeAt(idx -1)
                idx--
            } else {
                idx++
            }
        }

        return if (socks.isEmpty()) {
            "$moves"
        } else {
            "impossible"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(PairingSocks().solve(scanner))
}