package adventofcode.y2018

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Dec5Test : AbstractKotlinTest() {
    // unit test for first
    @Test
    fun firstUnitTest() {
        runTest(1, Dec5()::solve)
    }

    @Test
    fun first() {
        runTest(2, Dec5()::solve)
    }

    @Test
    fun secondUnitTest() {
        runTest(3, Dec5()::solve2)
    }

    @Test
    fun second() {
        runTest(2, Dec5()::solve2)
    }
}
