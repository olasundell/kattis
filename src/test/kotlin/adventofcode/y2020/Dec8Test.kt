package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec8Test : AbstractKotlinTest() {
    val simpleInput1 = """nop +0
acc +1
jmp +4
acc +3
jmp -3
acc -99
acc +1
jmp -4
acc +6"""

    @Test
    fun simple() {
        val result = Dec8().solve(Scanner(simpleInput1))

        assertEquals("5", result)
    }

    @Test
    fun one() {
        runTest(1, Dec8()::solve)
    }

    @Test
    fun two() {
        runTest(1, Dec8()::solve2)
    }
}