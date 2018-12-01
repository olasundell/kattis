import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PokerHandTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, PokerHand()::solve)
    }

    @Test
    fun two() {
        runTest(2, PokerHand()::solve)
    }

    @Test
    fun three() {
        runTest(3, PokerHand()::solve)
    }
}