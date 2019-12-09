import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

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
        Assert.assertEquals(3, n)
    }
}