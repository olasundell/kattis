import java.util.*

/**
 * TODO write documentation
 */
class DelimiterSoup {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()
        val s = scanner.nextLine()
        val stack = LinkedList<Char>()

        for (i in s.indices) {
            when (s[i]) {
                '{', '(', '[' -> stack.push(s[i])
                '}', ')', ']' -> if (stack.isEmpty() || stack.pop() != opposite(s[i])) return "${s[i]} $i"
            }
        }

        return "ok so far"
    }

    fun opposite(c: Char): Char {
        return when (c) {
            '}' -> '{'
            ']' -> '['
            ')' -> '('
            else -> throw IllegalArgumentException("$c is not valid")
        }
    }

}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(DelimiterSoup().solve(scanner))
}
