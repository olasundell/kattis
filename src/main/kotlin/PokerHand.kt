import java.util.Scanner;

/**
 * TODO write documentation
 */
class PokerHand {
    fun solve(scanner: Scanner): String {
        val cards = hashMapOf<Char, Int>()

        for (i in 1..5) {
            val card = readCard(scanner)
            cards.compute(card) { _, u -> if (u != null) u + 1 else 1 }
        }
        return cards.toList().sortedByDescending { k -> k.second }[0].second.toString()
    }

    private fun readCard(scanner: Scanner): Char {
        return scanner.next()[0]
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(PokerHand().solve(scanner))
}