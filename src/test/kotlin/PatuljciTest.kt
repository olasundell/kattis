import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PatuljciTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Patuljci()::solve)
    }

    @Test
    fun two() {
        runTest(2, Patuljci()::solve)
    }
}