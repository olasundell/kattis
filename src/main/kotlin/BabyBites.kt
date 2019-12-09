import java.util.Scanner;

/**
 * TODO write documentation
 */
class BabyBites {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        for (i in 1..n) {
            val w = scanner.next()
            if (i.toString() != w && "mumble" != w) {
                return "something is fishy"
            }
        }
        return "makes sense"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(BabyBites().solve(scanner))
}
