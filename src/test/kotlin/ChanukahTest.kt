import kattis.Chanukah
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class ChanukahTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Chanukah()::solve)
    }
}