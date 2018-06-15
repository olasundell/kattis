import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dunglish {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val sentence = mutableListOf<String>()

        for (i in 0 until n) {
            sentence.add(scanner.next())
        }

        val r = scanner.nextInt()

        val correct = mutableMapOf<String, Int>()
        val incorrect = mutableMapOf<String, Int>()
        val dictionary = mutableMapOf<String, String>()

        for (i in 0 until r) {
            val dutch = scanner.next()
            val english = scanner.next()
            val c = scanner.next()

            if (c == "correct") {
                correct.compute(dutch, { _, v -> (v ?: 0).plus(1) })
            } else {
                incorrect.compute(dutch, { _, v -> (v ?: 0).plus(1) })
            }
            dictionary[dutch] = english
        }

        var ok = 1
        var tot = 1

        for (s in sentence) {
            ok *= correct.getOrDefault(s, 0)
            tot *= (correct.getOrDefault(s, 0) + incorrect.getOrDefault(s, 0))
        }

        if (tot == 1) {
            return "${sentence.joinToString(separator = " ") { s -> dictionary[s].orEmpty() }}\n${if (ok == 0) {
                "incorrect"
            } else {
                "correct"
            }}"
        }

        return "$ok correct\n${tot - ok} incorrect"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dunglish().solve(scanner))
}