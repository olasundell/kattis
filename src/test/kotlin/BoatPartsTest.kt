import kattis.BoatParts
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class BoatPartsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, BoatParts()::solve)
    }
}