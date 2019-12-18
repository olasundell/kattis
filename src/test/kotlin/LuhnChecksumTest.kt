import kattis.LuhnChecksum
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class LuhnChecksumTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, LuhnChecksum()::solve)
    }
}