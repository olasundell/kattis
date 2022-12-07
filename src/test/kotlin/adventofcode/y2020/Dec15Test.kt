package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.*
import java.util.stream.Stream

/**
 * TODO write documentation
 */
internal class Dec15Test : AbstractKotlinTest() {
    @ParameterizedTest
    @MethodSource("numberProvider")
    fun simple1(input: String, expected: Int) {
        assertEquals(expected, Dec15().solve(input))
    }

    companion object {
        @JvmStatic
        fun numberProvider() = Stream.of(
//            Arguments.of("0,3,6", 436),
//            Arguments.of("1,3,2", 1),
//            Arguments.of("2,1,3", 10),
//            Arguments.of("1,2,3", 27),
//            Arguments.of("3,2,1", 438),
//            Arguments.of("3,1,2", 1836),
            Arguments.of("2,0,1,9,5,19", 1836),
        )
    }
}