import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class HarshadNumbersTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, HarshadNumbers()::solve)
    }
    @Test
    fun two() {
        runTest(2, HarshadNumbers()::solve)
    }
    @Test
    fun three() {
        runTest(3, HarshadNumbers()::solve)
    }
}