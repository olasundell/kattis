import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PairingSocksTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, PairingSocks()::solve)
    }

    @Test
    fun two() {
        runTest(2, PairingSocks()::solve)
    }

    @Test
    fun three() {
        runTest(3, PairingSocks()::solve)
    }

    @Test
    fun four() {
        runTest(4, PairingSocks()::solve)
    }


}