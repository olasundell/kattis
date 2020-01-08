import kattis.AsciiAddition
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class AsciiAdditionTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, AsciiAddition()::solve)
    }
}