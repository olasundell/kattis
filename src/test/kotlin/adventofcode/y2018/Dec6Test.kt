package adventofcode.y2018

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Dec6Test : AbstractKotlinTest() {
    @Test
    fun unitTestOne() {
        runTest(1, Dec6()::solve)
    }

    @Test
    fun one() {
        runTest(2, Dec6()::solve)
    }

    @Test
    fun two() {
        runTest(2, Dec6()::solve2)
    }
}