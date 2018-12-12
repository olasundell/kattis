package adventofcode.y2018

import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

class Dec7Test : AbstractKotlinTest() {
    @Test
    fun unitTest() {
        runTest(1, Dec7(-1, -1)::solve)
    }

    @Test
    fun first() {
        runTest(2, Dec7(-1 ,1)::solve)
    }

    @Test
    fun secondUnitTest() {
        runTest(3, Dec7(0, 2)::solve2)
    }

    @Test
    fun second() {
        runTest(4, Dec7(60, 5)::solve2)
    }
}