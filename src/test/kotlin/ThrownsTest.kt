import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class ThrownsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Throwns()::solve)
    }

    @Test
    fun two() {
        runTest(2, Throwns()::solve)
    }

    @Test
    fun three() {
        runTest(3, Throwns()::solve)
    }
}

