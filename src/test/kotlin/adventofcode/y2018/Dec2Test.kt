package adventofcode.y2018

import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

class Dec2Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec2()::solve)
    }

    @Test
    fun two() {
        runTest(1, Dec2()::solve2)
    }

    fun distance() {
        val s = "abc"
        val s2 = "abd"
    }
}