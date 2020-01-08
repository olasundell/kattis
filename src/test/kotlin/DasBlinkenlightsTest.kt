import kattis.DasBlinkenlights
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class DasBlinkenlightsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, DasBlinkenlights()::solve)
    }

    @Test
    fun two() {
        runTest(2, DasBlinkenlights()::solve)
    }
}