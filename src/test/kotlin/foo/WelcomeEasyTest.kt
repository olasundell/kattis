package foo

import foo.WelcomeEasy
import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class WelcomeEasyTest : AbstractKotlinTest() {
    @Test
    fun padSumShouldPad() {
        Assert.assertEquals("0001", WelcomeEasy().padSum(10001))
    }
    @Test
    fun one() {
        runTest(1, WelcomeEasy()::solve)
    }

    @Test
    fun two() {
        runTest(2, WelcomeEasy()::solve)
    }

    @Test
    fun three() {
        runTest(3, WelcomeEasy()::solve)
    }

    @Test
    fun four() {
        runTest(4, WelcomeEasy()::solve)
    }

    @Test
    fun five() {
        runTest(5, WelcomeEasy()::solve)
    }

    @Test
    fun six() {
        runTest(6, WelcomeEasy()::solve)
    }
}