package adventofcode.y2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.util.*

/**
 * TODO write documentation
 */
class Dec11Test : AbstractKotlinTest() {
    val oneIter = """#.##.##.##
#######.##
#.#.#..#..
####.##.##
#.##.##.##
#.#####.##
..#.#.....
##########
#.######.#
#.#####.##"""

    val twoIter = """#.LL.L#.##
#LLLLLL.L#
L.L.L..L..
#LLL.LL.L#
#.LL.LL.LL
#.LLLL#.##
..L.L.....
#LLLLLLLL#
#.LLLLLL.L
#.#LLLL.##"""

    val threeIter =
        """#.##.L#.##
              |#L###LL.L#
              |L.#.#..#..
              |#L##.##.L#
              |#.##.LL.LL
              |#.###L#.##
              |..#.#.....
              |#L######L#
              |#.LL###L.L
              |#.#L###.##""".trimMargin()

    val fourIter =
        """#.#L.L#.##
              |#LLL#LL.L#
              |L.L.L..#..
              |#LLL.##.L#
              |#.LL.LL.LL
              |#.LL#L#.##
              |..L.L.....
              |#L#LLLL#L#
              |#.LLLLLL.L
              |#.#L#L#.##""".trimMargin()

    val fiveIter =
        """#.#L.L#.##
              |#LLL#LL.L#
              |L.#.L..#..
              |#L##.##.L#
              |#.#L.LL.LL
              |#.#L#L#.##
              |..L.L.....
              |#L#L##L#L#
              |#.LLLLLL.L
              |#.#L#L#.##""".trimMargin()

    val iterInput = listOf(oneIter, twoIter, threeIter, fourIter, fiveIter, fiveIter)

    private val simpleInput = """L.LL.LL.LL
LLLLLLL.LL
L.L.L..L..
LLLL.LL.LL
L.LL.LL.LL
L.LLLLL.LL
..L.L.....
LLLLLLLLLL
L.LLLLLL.L
L.LLLLL.LL""".trimIndent()

    @Test
    fun calcSeatShouldWork() {
        val dec11 = Dec11()
        val list = dec11.read(
            Scanner(
                """LLL
            |LLL
            |LLL""".trimMargin()
            )
        )

        assertEquals('#', dec11.calcSeat(list, 1, 1))
        assertEquals('#', dec11.calcSeat(list, 0, 1))
        assertEquals('#', dec11.calcSeat(list, 1, 0))
        assertEquals('#', dec11.calcSeat(list, 0, 0))
        assertEquals('#', dec11.calcSeat(list, 2, 2))
    }

    @Test
    fun calcSeatRegression() {
        val input =   """#.LL.L#.##
                        |#LLLLLL.L#
                        |L.L.L..L..""".trimMargin()

        val expected= """#.##.L#.##
                        |#L###LL.L#
                        |L.#.#..#..""".trimMargin()


        val dec11 = Dec11()
        val list = dec11.read(
            Scanner(input)
        )

        assertEquals('L', dec11.calcSeat(list, 1, 1))
        assertEquals('#', dec11.calcSeat(list, 2, 0))
    }

    @Test
    fun calcSeatRegression2() {
        val input =
            """#.##.L#.##
              |#L###LL.L#
              |L.#.#..#..
              |#L##.##.L#""".trimMargin()

        val expected =
            """#.#L.L#.##
              |#LLL#LL.L#
              |L.L.L..#..
              |#LLL.##.L#""".trimMargin()

        val dec11 = Dec11()
        val list = dec11.read(
            Scanner(input)
        )

        assertEquals('L', dec11.calcSeat(list, 2, 2))
    }

    @Test
    fun calcSeatBiggerShouldWork() {
        val dec11 = Dec11()
        val list = dec11.read(
            Scanner(
                """####
            |####
            |####
            |####""".trimMargin()
            )
        )

        assertEquals('L', dec11.calcSeat(list, 1, 1))
        assertEquals('L', dec11.calcSeat(list, 0, 1))
        assertEquals('L', dec11.calcSeat(list, 1, 0))
        assertEquals('#', dec11.calcSeat(list, 0, 0))
        assertEquals('L', dec11.calcSeat(list, 2, 2))
        assertEquals('#', dec11.calcSeat(list, 3, 3))
    }

    @Test
    fun simpleOccupy() {
        val expected = """#.##.##.##
#######.##
#.#.#..#..
####.##.##
#.##.##.##
#.#####.##
..#.#.....
##########
#.######.#
#.#####.##"""

        val list: List<List<Char>> = Dec11().read(Scanner(simpleInput))
        val actual: List<List<Char>> = Dec11().occupy(list).list

        assertEquals(expected,
            actual.joinToString(separator = "\n") { it.joinToString(separator = "") }
        )
    }

    @Test
    fun simpleOccupyTwice() {

//        val input = listOf(threeIter, fourIter, fourIter)

        for (i in 0 until iterInput.size - 1) {
            val list: List<List<Char>> = Dec11().read(Scanner(iterInput[i]))
            val result = Dec11().occupy(list)

            assertEquals(iterInput[i + 1],
                result.list.joinToString(separator = "\n") { it.joinToString(separator = "") },
                "Failed at ${i}"
            )

            if (i == iterInput.size - 2) {
                assertFalse(result.changed)
            }
        }
    }

    @Test
    fun smallRun() {
        runTest(2, Dec11()::solve)
    }

    @Test
    fun one() {
        runTest(1, Dec11()::solve)
    }

    @Test
    fun onebis() {
        runTest(3, Dec11()::solve)
    }
}