import kattis.Quadrant
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class QuadrantTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Quadrant()::solve)
    }

    @Test
    fun two() {
        runTest(2, Quadrant()::solve)
    }
}