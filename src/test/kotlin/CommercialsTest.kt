import kattis.Commercials
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class CommercialsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Commercials()::solve)
    }
}