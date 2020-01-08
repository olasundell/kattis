import kattis.OwlAndFox
import org.junit.jupiter.api.Assertions
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * TODO write documentation
 */
class OwlAndFoxTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, OwlAndFox()::solve)
    }

    @Test
    fun mapping() {
        val n = "12".map { (it - '0') }.sum()
        assertEquals(3, n)
    }
}