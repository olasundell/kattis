import java.util.Scanner;

/**
 * TODO write documentation
 */
class Sort {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val c = scanner.nextInt()

        val numbers = mutableListOf<Int>()
        val counts = mutableMapOf<Int, Int>()
        val firstPos = mutableMapOf<Int, Int>()

        for (i in 1..n) {
            val element = scanner.nextInt()
            numbers.add(element)
            counts.compute(element) { _: Int, u: Int? -> u?.inc() ?: 1 }
            firstPos.putIfAbsent(element, i)
        }

        return sort(counts, firstPos)
    }

    private fun sort(counts: MutableMap<Int, Int>, firstPos: MutableMap<Int, Int>): String {
        val c = compareByDescending<MutableMap.MutableEntry<Int, Int>> { it.value }
        val thenBy = c.thenBy { firstPos[it.key] }
        return counts.entries.sortedWith(
                thenBy
//                compareByDescending(
//                        { it.value }
//                        compareByDescending<MutableMap.MutableEntry<Int, Int>> { it.value },
//                        compareBy<MutableMap.MutableEntry<Int, Int>>{ firstPos[it.key] }
//                ).th

        ).map { entry -> (1..entry.value).map { entry.key }.joinToString(separator = " ") }
                .joinToString(separator = " ")
//        counts.entries.sortedBy { mutableEntry -> mutableEntry.value }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Sort().solve(scanner))
}