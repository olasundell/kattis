import java.util.*

/**
 * TODO write documentation
 */
class HangingOut {
    fun solve(scanner: Scanner): String {
        val max = scanner.nextInt()
        val rows = scanner.nextInt()
        var current = 0
        var groups = 0

        for (i in 1..rows) {
            var action = scanner.next()
            var num = scanner.nextInt()

            when (action) {
                "enter" ->  if (num + current > max) {
                                groups++
                            } else {
                                current += num
                            }
                "leave" -> current -= num
            }
        }

        return groups.toString()
    }

}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(HangingOut().solve(scanner))
}
