import kattis.WhichBase
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class WhichBaseTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, WhichBase()::solve)
    }
}