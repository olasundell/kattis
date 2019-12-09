import java.util.Scanner;

/**
 * TODO write documentation
 */
class AlphabetAnimals {
    fun solve(scanner: Scanner): String {
        val animal = scanner.next()
        val fA = animal.last()
        val n = scanner.nextInt()

        val firstChars = mutableMapOf<Char, Int>()
        val correctAnimals = mutableListOf<String>()

        for (i in 1..n) {
            val a = scanner.next()
            if (a[0] == fA) {
                correctAnimals.add(a)
            }
            firstChars.compute(a[0]) { _, u -> u?.inc() ?: 1 }
        }

        return if (correctAnimals.isEmpty()) {
            "?"
        } else {
            killer(correctAnimals, firstChars)?.plus("!") ?: correctAnimals.first()
        }
    }

    private fun killer(correctAnimals: List<String>, firstChars: Map<Char, Int>): String? {
        val not = correctAnimals
        val ret = not.filter {
            if (it.last() == it.first()) {
                firstChars.getOrDefault(it.last(), 0) <= 1
            } else {
                !firstChars.containsKey(it.last())
            }
        }.firstOrNull()

        return ret
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(AlphabetAnimals().solve(scanner))
}