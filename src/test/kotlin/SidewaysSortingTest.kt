import kattis.SidewaysSorting
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class SidewaysSortingTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, SidewaysSorting()::solve)
    }

    @Test
    fun two() {
        runTest(2, SidewaysSorting()::solve)
    }
}