import kattis.Election
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class ElectionTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Election()::solve)
    }
}