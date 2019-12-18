import kattis.Relocation
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class RelocationTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Relocation()::solve)
    }
}