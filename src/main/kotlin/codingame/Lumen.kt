//11111
//12221
//12321
//12221
//11111
package codingame;

import java.awt.Point
import java.util.Scanner;
import kotlin.math.max
import kotlin.math.min

/**
 * TODO write documentation
 */
class Lumen {
	fun solve(scanner: Scanner): String {
		val n = scanner.nextInt()
		val c = scanner.nextInt()
		scanner.nextLine()

		val points = mutableSetOf<Point>()

		val m = (0 until n).mapIndexed { y, _ ->
			scanner.nextLine().split(" ")
				.mapIndexed { x, it ->
					if (it == "C") {
						points.add(Point(x, y))
						c
					} else 0
				}.toMutableList()
		}.toMutableList()

		points.forEach { point ->

			(1 until c).forEach { step ->
				val nbs = mutableSetOf<Point>()
			}
		}


		return ""
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Lumen().solve(scanner))
}