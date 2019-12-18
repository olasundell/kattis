import kattis.MissingNumbers
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class MissingNumbersTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, MissingNumbers()::solve)
    }

    @Test
    fun two() {
        runTest(2, MissingNumbers()::solve)
    }
}