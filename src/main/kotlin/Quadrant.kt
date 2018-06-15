import java.util.*

/**
 * TODO write documentation
 */

class Quadrant {
    fun solve(scanner: Scanner): String {
        val x = scanner.nextInt()
        val y = scanner.nextInt()

        if (y > 0) {
            if (x > 0) {
                return "1"
            } else {
                return "2"
            }
        } else {
            if (x > 0) {
                return "4"
            } else {
                return "3"
            }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Quadrant().solve(scanner))
}
