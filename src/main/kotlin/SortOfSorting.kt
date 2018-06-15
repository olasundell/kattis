import java.util.Scanner;

/**
 * TODO write documentation
 */
class SortOfSorting {
    fun solve(scanner: Scanner): String {
        val result = mutableListOf<MutableList<Word>>()

        while (scanner.hasNext()) {
            val n = scanner.nextInt()
            if (!n.equals(0)) {
                val words = mutableListOf<Word>()

                for (i in 0 until n) {
                    words.add(Word(i, scanner.next()))
                }
                words.sort()
                result.add(words)
            }
        }
        return result.joinToString(separator = "\n\n", transform = { l -> l.joinToString(separator = "\n") })
    }
}

class Word(val index: Int, val name: String) : Comparable<Word> {
    override fun compareTo(other: Word): Int {
        val first = name[0].compareTo(other.name[0])

        if (first == 0) {
            val second = name[1].compareTo(other.name[1])

            if (second == 0) {
                return index.compareTo(other.index)
            } else {
                return second
            }
        } else {
            return first
        }
    }

    override fun toString(): String {
        return name
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(SortOfSorting().solve(scanner))
}