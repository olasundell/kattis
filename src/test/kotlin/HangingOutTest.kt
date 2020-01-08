import kattis.HangingOut
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class HangingOutTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, HangingOut()::solve)
    }
}