package kattis

import java.util.Scanner;

/**
 * initially, all players stand in a circle with their hands folded together (like an intact coconut).
 * In clockwise order, one player touches the hands of the other players and says the rhyme: “Co-co-nut, Co-co-nut, Co-co-nut, Splat!”
 * At each syllable, the player touches a hand, and the player whose hand or hands is touched last takes one of the following actions:
 * If the player’s hands are still folded, they are split into two fists (the coconut is cracked in two halves).
 * The next round starts with the fist that is the first half of the coconut, then the second half, then going to the next player.
 * If a fist is touched last, the hand is turned palm down (the milk spills out).
 * The next round starts with the next hand in clockwise order, which could be the other hand of the same player,
 * or it could be the hand or folded hands belonging to the next player.
 * If a hand that is already turned palm down is touched last, the player to whom it belongs puts the hand behind their back
 * and this hand won’t be counted in the following rounds. The next round starts with the next hand in clockwise order as in the previous case.
 * If a player has put both of their hands behind their back, that player is out of the game. The game ends when there is only one player left.
 */
operator fun Int.plus(player: Player): Int = this + player.oneOrTwo()

class Coconut {
    fun solve(scanner: Scanner): String {
        val syllables = scanner.nextInt()
        val n = scanner.nextInt()

        val players = (1..n).map { Player(it) }.toMutableList()

        var index = 0
        while (players.size > 1) {
            var i = 1
            while (true) {
                if (i + players[index] > syllables) {
                    // magic happens
                    players[index].stuff(i + players[index])
                    break
                }
                i += players[index]
                index++
            }
        }

        return "${players.first()}"
    }
}

data class Player(
        val n: Int,
        val hands: Hands = Hands(folded = true, left = HandState.FOLDED, right = HandState.FOLDED)
) {
    fun stuff(hand: Int): Player {
//        return if (this.hands.folded) {
            return Player(this.n, hands = Hands(folded = false, left = HandState.FIST, right = HandState.FIST))
//        } else {

//            if (hand == 0) {
//
//            }
//        }
    }
    fun oneOrTwo(): Int {
        return if (hands.folded) {
            1
        } else {
            var n = 0
            if (hands.left == HandState.FIST || hands.left == HandState.PALM_DOWN) {
                n++
            }

            if (hands.right == HandState.FIST || hands.right == HandState.PALM_DOWN) {
                n++
            }

            n
        }
    }
}

/**
 * States:
 * folded (both hands count as one)
 *
 */
data class Hands(
        val folded: Boolean,
        val left: HandState,
        val right: HandState
) {

}

enum class HandState {
    FOLDED,
    FIST,
    PALM_DOWN,
    BEHIND_BACK
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Coconut().solve(scanner))
}