import java.awt.Point
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Prozor {
    fun solve(scanner: Scanner): String {
        val state = createState(scanner)
        val maxPoint = findMax(state)

        return drawMap(state, maxPoint)
    }

    private fun drawMap(state: State, maxPoint: MaxPoint): String {
        val result = mutableListOf("${maxPoint.sum}")
        for (y in 0 until state.rows) {
            var line = ""
            for (x in 0 until state.cols) {
                val c = maxPoint.char(x, y)
                line += if (c != null) {
                    c
                } else {
                    if (state.points.contains(Point(x, y))) {
                        '*'
                    } else {
                        '.'
                    }
                }
            }
            result += line
        }

        return result.joinToString(separator = "\n")
    }

    private fun createState(scanner: Scanner): State {
        val rows = scanner.nextInt()
        val cols = scanner.nextInt()
        val swatSize = scanner.nextInt()
        val points = mutableSetOf<Point>()

        for (y in 0 until rows) {
            val line = scanner.next()
            for (x in 0 until cols) {
                if (line[x] == '*') {
                    points += Point(x, y)
                }
            }
        }

        val state = State(rows, cols, points, swatSize)
        return state
    }

    private fun findMax(state: State): MaxPoint {
        var maxPoint = MaxPoint(-1, Point(-1, -1), state.swatSize)

        for (y in 0 until state.rows) {
            for (x in 0 until state.cols) {
                val sum = state.points.filter {
                    it.x < (x + state.swatSize - 1) && it.x > x && it.y < (y + state.swatSize - 1) && it.y > y
                }.size
                if (maxPoint.sum < sum) {
                    maxPoint = MaxPoint(sum, Point(x, y), state.swatSize)
                }
            }
        }

        return maxPoint
    }

    data class State(val rows: Int, val cols: Int, val points: Set<Point>, val swatSize: Int)
    data class MaxPoint(val sum: Int, val point: Point, val swatSize: Int) {
        val corners = setOf(point,
                Point(point.x, point.y + swatSize - 1),
                Point(point.x + swatSize - 1, point.y),
                Point(point.x + swatSize - 1, point.y + swatSize - 1))

        fun char(x: Int, y: Int): Char? {
            val p = Point(x ,y)
            return if (corners.contains(p)) {
                '+'
            } else if ((p.x == point.x || (p.x == point.x + swatSize - 1)) && (point.y < p.y && point.y + swatSize - 1 > p.y)) {
                '|'
            } else if ((p.y == point.y || (p.y == point.y + swatSize - 1)) && (point.x < p.x && point.x + swatSize - 1 > p.x)) {
                '-'
            } else {
                null
            }

        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Prozor().solve(scanner))
}