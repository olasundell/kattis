import java.util.*
import java.util.concurrent.ArrayBlockingQueue

/**
 * TODO write documentation
 */
class Hangman {
    fun solve(scanner: Scanner): String {
        val word = scanner.next().toSet().toMutableSet()
        val alphabet = ArrayDeque(scanner.next().toList())
        var tries = 0

        do {
            val c = alphabet.removeFirst()
            if (!word.remove(c)) {
                tries++
            }

        } while (tries < 10 && word.isNotEmpty() && alphabet.isNotEmpty())


        return if (tries == 10) {
            "LOSE"
        } else {
            "WIN"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Hangman().solve(scanner))
}