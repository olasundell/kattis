import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PigLatinTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, PigLatin()::solve)
    }

    @Test
    fun two() {
        runTest(2, PigLatin()::solve)
    }
}