import kattis.FlyingSafely
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class FlyingSafelyTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, FlyingSafely()::solve)
    }
}