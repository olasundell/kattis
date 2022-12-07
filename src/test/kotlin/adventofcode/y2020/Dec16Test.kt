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
internal class Dec16Test : AbstractKotlinTest() {
    val simpleInput = """class: 1-3 or 5-7
row: 6-11 or 33-44
seat: 13-40 or 45-50

your ticket:
7,1,14

nearby tickets:
7,3,47
40,4,50
55,2,20
38,6,12"""

    @Test
    fun simple1() {
        val actual = Dec16().solve(Scanner(simpleInput))
        assertEquals("71", actual)
    }

    @ParameterizedTest
    @MethodSource("valueProvider")
    fun isValidValue(i: Int, rules: Map<String, Dec16.Rule>, expected: Boolean) {
        val actual = Dec16().isValidValue(i, rules)
        assertEquals(expected, actual)
    }


    @Test
    fun readRules() {
        val actual = Dec16().readRules(Scanner(simpleInput))
        val expected = mapOf("class" to Dec16.Rule(1..3, 5..7), "row" to Dec16.Rule(6..11, 33..44), "seat" to Dec16.Rule(13..40, 45..50))

        assertEquals(expected, actual)
    }

    @Test
//    fun findWrongValues(rules: Map<String, Dec16.Rule<IntRange, IntRange>>, tickets: List<List<Int>>) {
    fun findWrongValues() {
        val rules = mapOf("e" to Dec16.Rule(1..5, 7..10), "f" to Dec16.Rule(1..2, 4..5))
        val nearbyTickets = listOf(listOf(1,2,11), listOf(1,2,3))
        val actual = Dec16().findWrongValues(rules, nearbyTickets)
        val expected = listOf(11)

        assertEquals(expected, actual)
    }

    @Test
    fun f() {
        val list = listOf(listOf(1, 2, 3), listOf(2, 3, 4))
        val filtered = list.fold(listOf<Int>()) { acc, l: List<Int> -> acc + l.filterNot { it == 2 } }

//        var filtered = listOf<Int>()
//
//        filtered = filtered + list[0].filterNot { it ==2 }
//        filtered = filtered + list[1].filterNot { it ==2 }

        assertEquals(listOf(1, 3, 3, 4), filtered)
    }

    @Test
    fun one() {
        runTest(1, Dec16()::solve)
    }

    @Test
    fun simple2() {
        val actual = Dec16().solve2(Scanner(simpleInput))
    }

    @Test
    fun two() {
        runTest(1, Dec16()::solve2)
    }

    companion object {
        @JvmStatic
        fun valueProvider() = Stream.of(
            Arguments.of(3, mapOf("f" to Dec16.Rule(1..2, 4..5)), false),
            Arguments.of(2, mapOf("f" to Dec16.Rule(1..2, 4..5)), true),
            Arguments.of(2, mapOf("e" to Dec16.Rule(1..5, 7..10), "f" to Dec16.Rule(1..2, 4..5)), true),
            Arguments.of(2, mapOf("f" to Dec16.Rule(1..2, 4..5), "g" to Dec16.Rule(33..44, 55..66)), true),
            Arguments.of(35, mapOf("f" to Dec16.Rule(1..2, 4..5), "g" to Dec16.Rule(33..44, 55..66)), true),
            Arguments.of(30, mapOf("f" to Dec16.Rule(1..2, 4..5), "g" to Dec16.Rule(33..44, 55..66)), false),
        )
    }
}