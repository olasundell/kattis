package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class Dec2Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec2()::solve)
    }
}