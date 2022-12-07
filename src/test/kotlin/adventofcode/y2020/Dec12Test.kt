package adventofcode.y2020

import adventofcode.y2020.Dec12.Dir.*
import adventofcode.y2020.Dec12.Turn.*
import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec12Test : AbstractKotlinTest() {
    val simpleInput = """F10
N3
F7
R90
F11"""

    private lateinit var dec12: Dec12

    @BeforeEach
    fun init() {
        dec12 = Dec12()
    }

//    @Test
    fun simple() {
        val actual = dec12.solve(Scanner(simpleInput))
        assertEquals("25", actual)
    }

    @Test
    fun simple2() {
        val actual = dec12.solve(Scanner(simpleInput))
        assertEquals("286", actual)
    }

    @Test
    fun two() {
        runTest(1, Dec12()::solve)
    }

//    @Test
//    fun turningShouldWork() {
//        val actual = dec12.turn(N, 90, L)
//        assertEquals(E, actual)
//    }
//
//    @Test
//    fun one() {
//        runTest(1, Dec12()::solve)
//    }
}