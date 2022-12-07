package adventofcode.y2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.awt.Point
import java.util.*

/**
 * TODO write documentation
 */
class `Dec11-2Test`: AbstractKotlinTest() {
    private val firstInput = """L.LL.LL.LL
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL
    """.trimIndent()

    private val secondInput = """#.##.##.##
#######.##
#.#.#..#..
####.##.##
#.##.##.##
#.#####.##
..#.#.....
##########
#.######.#
#.#####.##"""

    private val thirdInput = """#.LL.LL.L#
#LLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLL#
#.LLLLLL.L
#.LLLLL.L#"""

    private val fourthInput = """#.L#.##.L#
#L#####.LL
L.#.#..#..
##L#.##.##
#.##.#L.##
#.#####.#L
..#.#.....
LLL####LL#
#.L#####.L
#.L####.L#"""

    private val fifthInput = """#.L#.L#.L#
#LLLLLL.LL
L.L.L..#..
##LL.LL.L#
L.LL.LL.L#
#.LLLLL.LL
..L.L.....
LLLLLLLLL#
#.LLLLL#.L
#.L#LL#.L#"""

    private val sixthInput = """#.L#.L#.L#
#LLLLLL.LL
L.L.L..#..
##L#.#L.L#
L.L#.#L.L#
#.L####.LL
..#.#.....
LLL###LLL#
#.LLLLL#.L
#.L#LL#.L#"""

    private val seventhInput = """#.L#.L#.L#
#LLLLLL.LL
L.L.L..#..
##L#.#L.L#
L.L#.LL.L#
#.LLLL#.LL
..#.L.....
LLL###LLL#
#.LLLLL#.L
#.L#LL#.L#"""

    private val iterInput = listOf(firstInput, secondInput, thirdInput, fourthInput, fifthInput, sixthInput, seventhInput, seventhInput)
    val dec = `Dec11-2`()
    private val simpleInput =
        """L.LL.LL.LL
          |LLLLLLL.LL
          |L.L.L..L..
          |LLLL.LL.LL
          |L.LL.LL.LL
          |L.LLLLL.LL
          |..L.L.....
          |LLLLLLLLLL
          |L.LLLLLL.L
          |L.LLLLL.LL""".trimMargin()

    @Test
    fun traceShouldWork() {
        val expected = listOf(Point(0, 1), Point(1, 1), Point(2, 0))
        val list = dec.read(Scanner(simpleInput))
        val actual = dec.trace(list, 0, 0)
        assertEquals(expected, actual)

        val actual2 = dec.trace(list, 1, 7).toSet()
        val expected2 = listOf(Point(0, 7), Point(0, 8), Point(1, 3), Point(2, 6), Point(2, 7), Point(2, 8)).toSet()
        assertEquals(expected2, actual2)

        val actual3 = dec.trace(list, 8, 1).toSet()
        val expected3 = setOf(Point(8, 0), Point(9, 0), Point(9, 1), Point(7, 2), Point(8, 3), Point(6, 1))
        assertEquals(expected3, actual3)
    }

    @Test
    fun simple2() {
        for (i in 0 until iterInput.size - 1) {
            val list: List<List<Char>> = dec.read(Scanner(iterInput[i]))
            val result = dec.occupy2(list, dec.buildLookup(list))

            assertEquals(
                iterInput[i + 1],
                result.list.joinToString(separator = "\n") { it.joinToString(separator = "") },
                "Failed at ${i}"
            )

            if (i == iterInput.size - 2) {
                assertFalse(result.changed)
            }
        }
    }

    @Test
    fun one() {
        runTest(1, dec::solve2)
    }
}