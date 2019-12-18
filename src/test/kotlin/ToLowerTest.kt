import kattis.ToLower
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class ToLowerTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, ToLower()::solve)
    }
}