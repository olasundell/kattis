import kattis.PebbleSolitaire
import org.junit.jupiter.api.Test
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