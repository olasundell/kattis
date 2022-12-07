package adventofcode.y2020;

import java.util.*

typealias Deck = LinkedList<Int>

typealias PrevStates = MutableSet<Pair<String, String>>

/**
 * TODO write documentation
 */
class Dec22 {
    fun solve(scanner: Scanner): String {
        val (deck1, deck2) = readDecks(scanner)

        while (deck1.isNotEmpty() && deck2.isNotEmpty()) {
            battle(deck1, deck2)
        }

        return calcScore(deck1, deck2)
    }

    fun solve2(scanner: Scanner): String {
        val (deck1, deck2) = readDecks(scanner)

        battle2(deck1, deck2, mutableSetOf())

        return calcScore(deck1, deck2)
    }

    private fun battle2(deck1: Deck, deck2: Deck, states: PrevStates) {
        while (deck1.isNotEmpty() && deck2.isNotEmpty()) {
//            println(deck1.joinToString(separator = ", "))
//            println(deck2.joinToString(separator = ", "))
//            println()
            val state = createState(deck1, deck2)

            val c1 = deck1.removeFirst()
            val c2 = deck2.removeFirst()

            if (states.contains(state)) {
                deck1.add(c1)
                deck1.add(c2)
            } else {
                states.add(state)
                if (deck1.size >= c1 && deck2.size >= c2) {
                    // recursive combat
//                    println("Recursing")
                    val d1 = Deck(deck1.subList(0, c1))
                    val d2 = Deck(deck2.subList(0, c2))
                    battle2(d1, d2, mutableSetOf())
                    if (d1.isNotEmpty()) {
                        deck1.add(c1)
                        deck1.add(c2)
                    } else {
                        deck2.add(c2)
                        deck2.add(c1)
                    }
                } else {
                    if (c1 > c2) {
                        deck1.add(c1)
                        deck1.add(c2)
                    } else {
                        deck2.add(c2)
                        deck2.add(c1)
                    }
                }
            }
        }
    }

    private fun createState(deck1: Deck, deck2: Deck): Pair<String, String> {
        return deck1.joinToString(separator = ",") to deck2.joinToString(separator = ",")
    }

    private fun calcScore(deck1: Deck, deck2: Deck): String {
        val d = if (deck1.isNotEmpty()) {
            deck1
        } else {
            deck2
        }

        return d.foldRightIndexed(0) { index, i, acc -> acc + i * (d.size - index) }.toString()
    }

    private fun readDecks(scanner: Scanner): Pair<Deck, Deck> {
        scanner.nextLine()
        val deck1 = Deck()
        val deck2 = Deck()

        while (scanner.hasNextInt()) {
            deck1.add(scanner.nextInt())
        }

        scanner.nextLine()
        scanner.nextLine()
        scanner.nextLine()

        while (scanner.hasNextInt()) {
            deck2.add(scanner.nextInt())
        }
        return Pair(deck1, deck2)
    }

    fun battle(deck1: Deck, deck2: Deck) {
        val c1 = deck1.removeFirst()
        val c2 = deck2.removeFirst()

        if (c1 > c2) {
            deck1.add(c1)
            deck1.add(c2)
        } else {
            deck2.add(c2)
            deck2.add(c1)
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec22().solve(scanner))
}