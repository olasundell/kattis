import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class PrincessPeachTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, PrincessPeach()::solve)
    }
}