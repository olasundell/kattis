package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class DamagedEquationTest : AbstractKotlinTest() {
    @Test
    fun shouldEquals() {
        val o1 = DamagedEquation.Sub(3, 2)
        val o2 = DamagedEquation.Sub(4, 3)
        assertEquals(o1, o2)

        val m1 = DamagedEquation.Mul(1, 1)
        val m2 = DamagedEquation.Sub(4, 3)
        assertEquals(m1, m2)
    }

    @Test
    fun one() {
        runTest(1, DamagedEquation()::solve)
    }

    @Test
    fun two() {
        runTest(2, DamagedEquation()::solve)
    }

    @Test
    fun three() {
        runTest(2, DamagedEquation()::solve)
    }
}