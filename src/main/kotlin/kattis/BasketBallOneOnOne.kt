package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class BasketBallOneOnOne {
	fun solve(scanner: Scanner): String {
		val chunk = scanner.nextLine().chunked(2)
		val score = chunk.fold(Score(0, 0)) {
				acc, s ->  if (s[0] == 'A') {
					acc + (s[1].toInt() to 0)
				} else {
					acc + (0 to s[1].toInt())
				}
		}
		return score.winner()
	}

	data class Score(val a: Int, val b: Int) {
		operator fun plus(pair: Pair<Int, Int>): Score = Score(this.a + pair.first, this.b + pair.second)
		fun winner(): String = if (a > b) { "A" } else { "B" }
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(BasketBallOneOnOne().solve(scanner))
}