import kattis.Planina
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PlaninaTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Planina()::solve)
    }
    @Test
    fun two() {
        runTest(2, Planina()::solve)
    }
    @Test
    fun three() {
        runTest(3, Planina()::solve)
    }
}