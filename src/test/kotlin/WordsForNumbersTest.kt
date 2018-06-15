import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class WordsForNumbersTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTestTokenizer(1, WordsForNumbers()::solve)
    }
}