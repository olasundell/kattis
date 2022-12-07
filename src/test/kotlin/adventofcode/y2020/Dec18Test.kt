package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

/**
 * TODO write documentation
 */
internal class Dec18Test : AbstractKotlinTest() {
    @ParameterizedTest
    @MethodSource("exprs")
    fun simple1(input: String, expected: String) {
        val actual = Dec18().solve(Scanner(input))
        assertEquals(expected, actual)
    }

    @ParameterizedTest
    @MethodSource("exprs2")
    fun simple2(input: String, expected: String) {
        val actual = Dec18(true).solve(Scanner(input))
        assertEquals(expected, actual)
    }

    @Test
    fun shuntyard() {
        val actual = Dec18(true).shuntYard("1+2*3".toCharArray())
        assertEquals("1 2 + 3 *", actual)
    }

    @Test
    fun one() {
        runTest(1, Dec18()::solve)
    }

    @Test
    fun two() {
        runTest(1, Dec18(true)::solve)
    }


    companion object {
        @JvmStatic
        fun exprs2() = Stream.of(
            Arguments.of("1 + 2 * 3 + 4 * 5 + 6", "231"),
            Arguments.of("1 + (2 * 3) + (4 * (5 + 6))", "51"),
            Arguments.of("2 * 3 + (4 * 5)", "46"),
            Arguments.of("5 + (8 * 3 + 9 + 3 * 4 * 3)", "1445"),
            Arguments.of("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))", "669060")
        )

        @JvmStatic
        fun exprs() = Stream.of(
            Arguments.of("1 + 2 * 3 + 4 * 5 + 6", "71"),
            Arguments.of("1 + (2 * 3) + (4 * (5 + 6))", "51"),
            Arguments.of("2 * 3 + (4 * 5)", "26"),
            Arguments.of("""5 + (8 * 3 + 9 + 3 * 4 * 3)
                |5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))""".trimMargin(), "12677")
        )
    }
}