package adventofcode.y2020

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import util.AbstractKotlinTest
import java.util.*
import java.util.stream.Stream
import kotlin.test.assertEquals

/**
 * TODO write documentation
 */
internal class Dec14Test : AbstractKotlinTest() {
    val simpleInput1 = """mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X
mem[8] = 11
mem[7] = 101
mem[8] = 0"""

    val simpleInput2 = """mask = 000000000000000000000000000000X1001X
mem[42] = 100
mask = 00000000000000000000000000000000X0XX
mem[26] = 1"""

    private lateinit var dec14: Dec14

    @BeforeEach
    fun init() {
        dec14 = Dec14()
    }

    @Test
    fun simple1() {
        val actual = dec14.solve(Scanner(simpleInput1))
        assertEquals("165", actual)
    }

    @Test
    fun one() {
        runTest(1, dec14::solve)
    }

    @Test
    fun simple2() {
        val actual = dec14.solve2(Scanner(simpleInput2))
        assertEquals("208", actual)
    }

    @Test
    fun flatMap() {
        val l = listOf("010", "110")
        val actual: List<String> = l.flatMap { listOf("1" + it) + listOf("0" + it) }

        assertEquals(listOf("1010", "0010", "1110", "0110"), actual)
    }

    @Test
    fun two() {
        runTest(1, dec14::solve2)
    }

    @ParameterizedTest
    @MethodSource("mask2Params")
    fun mask2ShouldWork(mask: String, input: Int, expected: List<Long>) {
        val actual = dec14.mask2(mask.reversed(), input)

        assertEquals(expected.toSet() , actual.toSet())
    }

    companion object {
        @JvmStatic
        fun mask2Params() = Stream.of(
//            Arguments.of("XX", 1, listOf<Long>(0, 1, 2, 3)),
//            Arguments.of("XXX", 1, listOf<Long>(0, 1, 2, 3, 4, 5, 6, 7)),
//            Arguments.of("XXXX", 1, (0L..15L).toList()),
//            Arguments.of("X", 8, listOf(8L, 9L)),
//            Arguments.of("1X", 8, listOf(10L, 11L)),
//            Arguments.of("XX", 8, listOf(8L, 9L, 10L, 11L)),
//            Arguments.of("X1X", 8, listOf<Long>(10, 11, 14, 15)),
//            Arguments.of("X0X", 8, listOf<Long>(8, 9, 12, 13)),
//            Arguments.of("X0000", 8, listOf<Long>(8, 24)),
//            Arguments.of("X000", 8, listOf<Long>(8, 0)),
            Arguments.of("1X01 XXX0 0110 1X00 0011 11X1 011X 1010 1101".replace(" ", ""), 0, listOf<Long>())
//            Arguments.of("1X01XXX001101X00001100X1010X10101101", 62085, listOf<Long>())
//            Arguments.of("X10X", 8, listOf<Long>(10, 11, 14, 15)),
//            Arguments.of("1X01XXX001101X00001100X1010X10101101", 62085, listOf<Long>())
        )
    }
}