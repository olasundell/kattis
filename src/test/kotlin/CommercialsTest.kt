import org.junit.Assert.*
import org.junit.Test
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