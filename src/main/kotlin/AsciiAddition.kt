import java.util.Scanner;

/**
 * TODO write documentation
 */
class AsciiAddition {
    val zero = """
        |xxxxx
        |x...x
        |x...x
        |x...x
        |x...x
        |x...x
        |xxxxx
    """.trimMargin()

    val one = """
        |....x
        |....x
        |....x
        |....x
        |....x
        |....x
        |....x
        """.trimMargin()

    val two = """
        |xxxxx
        |....x
        |....x
        |xxxxx
        |x....
        |x....
        |xxxxx
        """.trimMargin()

    val three = """
        |xxxxx
        |....x
        |....x
        |xxxxx
        |....x
        |....x
        |xxxxx
        """.trimMargin()

    val four = """
        |x...x
        |x...x
        |x...x
        |xxxxx
        |....x
        |....x
        |....x
        """.trimMargin()

    val five = """
        |xxxxx
        |x....
        |x....
        |xxxxx
        |....x
        |....x
        |xxxxx
        """.trimMargin()

    val six = """
        |xxxxx
        |x....
        |x....
        |xxxxx
        |x...x
        |x...x
        |xxxxx
        """.trimMargin()

    val seven = """
        |xxxxx
        |....x
        |....x
        |....x
        |....x
        |....x
        |....x
        """.trimMargin()

    val eight = """
        |xxxxx
        |x...x
        |x...x
        |xxxxx
        |x...x
        |x...x
        |xxxxx
        """.trimMargin()

    val nine = """
        |xxxxx
        |x...x
        |x...x
        |xxxxx
        |....x
        |....x
        |xxxxx
        """.trimMargin()

    val plus = """
        |.....
        |..x..
        |..x..
        |xxxxx
        |..x..
        |..x..
        |.....
        """.trimMargin()

    fun solve(scanner: Scanner): String {
        return ""
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(AsciiAddition().solve(scanner))
}