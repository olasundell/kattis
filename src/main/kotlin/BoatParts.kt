import java.util.Scanner;

/**
 * TODO write documentation
 */
class BoatParts {
    fun solve(scanner: Scanner): String {
        val p = scanner.nextInt()
        val n = scanner.nextInt()
        val parts = mutableSetOf<String>()

        for (i in 1..n) {
            parts.add(scanner.next())
            if (parts.size == p) {
                return i.toString()
            }
        }

        return "paradox avoided"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(BoatParts().solve(scanner))
}