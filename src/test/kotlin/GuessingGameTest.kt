import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class GuessingGameTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, GuessingGame()::solve)
    }

    @Test
    fun two() {
        runTest(2, GuessingGame()::solve)
    }
}