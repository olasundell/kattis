import kattis.Loowater
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class LoowaterTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Loowater()::solve)
    }

    @Test
    fun two() {
        runTest(2, Loowater()::solve)
    }

    @Test
    fun three() {
        runTest(3, Loowater()::solve)
    }

    @Test
    fun four() {
        runTest(4, Loowater()::solve)
    }

    @Test
    fun five() {
        runTest(5, Loowater()::solve)
    }
}