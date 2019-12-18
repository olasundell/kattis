import kattis.Natrij
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class NatrijTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Natrij()::solve)
    }

    @Test
    fun two() {
        runTest(2, Natrij()::solve)
    }
}