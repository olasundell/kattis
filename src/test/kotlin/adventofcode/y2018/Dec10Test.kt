package adventofcode.y2018

import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

class Dec10Test : AbstractKotlinTest() {
    @Test
    fun unitTest() {
        runTest(1, Dec10()::solve)
    }

    @Test
    fun first() {
        runTest(2, Dec10()::solve)
    }
}