import kattis.PrincessPeach
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class PrincessPeachTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, PrincessPeach()::solve)
    }
}