package adventofcode.y2018

import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

class Dec8Test : AbstractKotlinTest() {
    @Test
    fun firstUnitTest() {
        runTest(1, Dec8()::solve)
    }

    @Test
    fun first() {
        runTest(2, Dec8()::solve)
    }

    @Test
    fun secondUnitTest() {
        runTest(3, Dec8()::solve2)
    }

    @Test
    fun second() {
        runTest(4, Dec8()::solve2)
    }
}