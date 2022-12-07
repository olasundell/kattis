package adventofcode.y2021;

import java.awt.Point
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec13(private val print: Boolean, private val afterFirst: Boolean = false) {
	fun solve(scanner: Scanner): String {
		val points = mutableListOf<Point>()
		val folds = mutableListOf<Fold>()
		while (scanner.hasNextLine()) {
			val line = scanner.nextLine()
			if (line.contains(",")) {
				points.add(Point(line.split(",")[0].toInt(), line.split(",")[1].toInt()))
			}

			if (line.startsWith("fold along")) {
				val l = line.substring("fold along ".length).split("=")

				folds.add(Fold(axis = l[0], n = l[1].toInt()))
			}
		}

//		System.err.println(stringify(points.toSet()))

		val foldings = folds.fold(points.toSet()) { acc, fold ->
			val n = acc.map { convertP(it, fold) }.toSet()

//			System.err.println("==================================")
//			System.err.println(stringify(n.toSet()))

			if (afterFirst) {
				return "${n.size}"
			}
			n
		}

		return if (print) {
			stringify(foldings)
		} else {
			"${foldings.size}"
		}
	}

	fun convertP(p: Point, fold: Fold): Point {
		return if (fold.axis == "y") {
			if (p.y > fold.n) {
				val dy = (p.y - fold.n) * 2
				Point(p.x, p.y - dy)
			} else {
				p
			}
		} else {
			if (p.x > fold.n) {
				val dx = (p.x - fold.n) * 2
				Point(p.x - dx, p.y)
			} else {
				p
			}
		}
	}

	private fun stringify(foldings: Set<Point>): String {
		val maxY = foldings.maxBy { it.y }.y
		val maxX = foldings.maxBy { it.x }.x

		val arr2 = Array<Array<Char>>(maxY + 1) { Array(maxX + 1) { '.' } }

		foldings.forEach {
			arr2[it.y][it.x] = '#'
		}

		return arr2.joinToString("\n") { it.joinToString("") }
	}


	data class Fold(val axis: String, val n: Int)
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec13(true).solve(scanner))
}