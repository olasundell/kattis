import kattis.Sibice
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class SibiceTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Sibice()::solve)
    }

    @Test
    fun two() {
        runTest(2, Sibice()::solve)
    }
}