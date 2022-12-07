package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class SimpleCronSpecTest : AbstractKotlinTest() {
    @Test
    fun parseSimple() {
        val p = SimpleCronSpec().parse("1", 24)
        assertEquals(setOf(1), p)
    }

    @Test
    fun parseComma() {
        val p = SimpleCronSpec().parse("1,2", 24)
        assertEquals(setOf(1, 2), p)
    }

    @Test
    fun parseStar() {
        val p = SimpleCronSpec().parse("*", 25)
        assertEquals((0..24).toSet(), p)
    }

    @Test
    fun parseRange() {
        val p = SimpleCronSpec().parse("2-4", 24)
        assertEquals(setOf(2, 3, 4), p)
    }

    @Test
    fun parseComplex() {
        val p = SimpleCronSpec().parse("20,25,30-33", 60)
        assertEquals(setOf(20, 25, 30, 31, 32, 33), p)
    }

    @Test
    fun zero() {
        runTest(0, SimpleCronSpec()::solve)
    }

    @Test
    fun one() {
        runTest(1, SimpleCronSpec()::solve)
    }

    @Test
    fun two() {
        runTest(2, SimpleCronSpec()::solve)
    }
}