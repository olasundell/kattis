package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec10Test : AbstractKotlinTest() {
    val s = """[({(<(())[]>[[{[]{<()<>>
[(()[<>])]({[<{<<[]>>(
{([(<{}[<>[]}>{[]{[(<()>
(((({<>}<{<{<>}{[]{[]{}
[[<[([]))<([[{}[[()]]]
[{[{({}]{}}([{[{{{}}([]
{<[[]]>}<{[{[{[]{()[[[]
[<(<(<(<{}))><([]([]()
<{([([[(<>()){}]>(<<{{
<{([{{}}[<[[[<>{}]]]>[]]"""

    @Test
    fun simple() {
        val result = Dec10().solve(Scanner(s))

        assertEquals("26397", result)
    }

    @Test
    fun one() {
        runTest(1, Dec10()::solve)
    }

    @Test
    fun simple2() {
        val result = Dec10().solve2(Scanner(s))

        assertEquals("288957", result)
    }

    @Test
    fun two() {
        runTest(1, Dec10()::solve2)
    }
}