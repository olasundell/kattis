import kattis.Egypt
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class EgyptTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Egypt()::solve)
    }
}