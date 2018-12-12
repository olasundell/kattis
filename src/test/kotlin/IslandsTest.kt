import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class IslandsTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Islands()::solve)
    }

    @Test
    fun two() {
        runTest(2, Islands()::solve)
    }
}