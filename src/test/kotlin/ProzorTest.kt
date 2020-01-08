import kattis.Prozor
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class ProzorTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Prozor()::solve)
    }

    @Test
    fun two() {
        runTest(2, Prozor()::solve)
    }

    @Test
    fun three() {
        runTest(3, Prozor()::solve)
    }

    @Test
    fun four() {
        runTest(4, Prozor()::solve)
    }

    @Test
    fun five() {
        runTest(5, Prozor()::solve)
    }

    @Test
    fun six() {
        runTest(6, Prozor()::solve)
    }

    @Test
    fun seven() {
        runTest(7, Prozor()::solve)
    }
}
