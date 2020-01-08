package adventofcode.y2018

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Dec9Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec9()::solve)
    }

    @Test
    fun two() {
        runTest(2, Dec9()::solve)
    }

    @Test
    fun three() {
        runTest(3, Dec9()::solve)
    }

    @Test
    fun four() {
        runTest(4, Dec9()::solve)
    }

    @Test
    fun five() {
        runTest(5, Dec9()::solve)
    }

    @Test
    fun six() {
        runTest(6, Dec9()::solve)
    }

    @Test
    fun seven() {
        runTest(7, Dec9()::solve)
    }
}