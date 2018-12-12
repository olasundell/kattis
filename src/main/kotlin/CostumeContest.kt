import java.util.*

class CostumeContest {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()

        val map = mutableMapOf<String, Int>()
        while (scanner.hasNext()) {
            val c = scanner.nextLine()
            map.compute(c) { _, u -> u?.plus(1) ?: 1 }
        }

        val sorted = map.toList().sortedBy { (_, value) -> value }

        val no = sorted[0].second
        return sorted.filter { e -> e.second == no }.sortedBy { (key, _) -> key }.joinToString("\n") { e -> e.first }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(CostumeContest().solve(scanner))
}