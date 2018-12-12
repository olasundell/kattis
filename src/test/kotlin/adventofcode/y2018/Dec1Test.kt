package adventofcode.y2018

import org.junit.Test
import util.AbstractKotlinTest

class Dec1Test: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec1()::solve)
    }

    @Test
    fun two() {
        runTest(1, Dec1()::solve2)
    }
}