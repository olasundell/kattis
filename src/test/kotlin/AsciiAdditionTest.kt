import org.junit.Assert.*
import org.junit.Test
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