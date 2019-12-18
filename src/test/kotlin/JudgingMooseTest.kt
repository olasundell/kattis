import kattis.JudgingMoose
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class JudgingMooseTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, JudgingMoose()::solve)
    }
    @Test
    fun two() {
        runTest(2, JudgingMoose()::solve)
    }
    @Test
    fun three() {
        runTest(3, JudgingMoose()::solve)
    }
}