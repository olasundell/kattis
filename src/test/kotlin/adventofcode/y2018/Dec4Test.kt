package adventofcode.y2018

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Dec4Test : AbstractKotlinTest() {
    // "real" first star of the day
    @Test
    fun one() {
        runTest(1, Dec4()::solve)
    }

    // unit test for first star
    @Test
    fun two() {
        runTest(2, Dec4()::solve)
    }

    // "real" second star
    @Test
    fun three() {
        runTest(3, Dec4()::solve2)
    }

    // unit test for second star
    @Test
    fun four() {
        runTest(4, Dec4()::solve2)
    }
}