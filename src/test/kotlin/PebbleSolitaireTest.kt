import kattis.PebbleSolitaire
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PebbleSolitaireTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, PebbleSolitaire()::solve)
    }
}