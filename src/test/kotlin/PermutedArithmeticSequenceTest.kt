import kattis.PermutedArithmeticSequence
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PermutedArithmeticSequenceTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, PermutedArithmeticSequence()::solve)
    }
}