package adventofcode.y2019

import kotlinx.coroutines.runBlocking
import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class Dec5Test : AbstractKotlinTest() {
    @Test
    fun block() {
        var i = -1
        runBlocking {
            i = 0
        }

        assertEquals(0, i)
    }

    @Test
    fun one() {
        runTest(1, Dec5()::solve)
    }

    @Test
    fun two() {
        runTest(2, Dec5()::solve)
    }

    @Test
    fun three() {
        runTest(3, Dec5()::solve)
    }

    @Test
    fun four() {
        runTest(4, Dec5()::solve)
    }

    @Test
    fun `immediate mode, input is equal to 8`() {
        runTest(5, Dec5()::solve)
    }

    @Test
    fun `immediate mode, input is less than 8`() {
        runTest(6, Dec5()::solve)
    }

    @Test
    fun seven() {
        runTest(7, Dec5()::solve)
    }

    @Test
    fun nine() {
        runTest(9, Dec5()::solve)
    }

    @Test
    fun ten() {
        runTest(10, Dec5()::solve)
    }

    @Test
    fun eleven() {
        runTest(11, Dec5()::solve)
    }

    @Test
    fun immPos() {
        val result = Dec5.ParamMode(21002)
        Assert.assertEquals(Dec5.Mode.POSITION, result.first)
        Assert.assertEquals(Dec5.Mode.IMMEDIATE, result.second)
        Assert.assertEquals(Dec5.Mode.RELATIVE, result.third)
    }
}