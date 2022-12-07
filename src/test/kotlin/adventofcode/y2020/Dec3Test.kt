package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec3Test : AbstractKotlinTest() {
        val input = """..##.......
#...#...#..
.#....#..#.
..#.#...#.#
.#...##..#.
..#.##.....
.#.#.#....#
.#........#
#.##...#...
#...##....#
.#..#...#.#
""".trimIndent()

    @Test
    fun simple() {
        val result = Dec3().solve(Scanner(input))

        assertEquals("7", result)
    }

    @Test
    fun one() {
        runTest(1, Dec3()::solve)
    }

    @Test
    fun simple2() {
        val result = Dec3().solve2(Scanner(input))

        assertEquals("336", result)
    }

    @Test
    fun two() {
        runTest(1, Dec3()::solve2)
    }
}