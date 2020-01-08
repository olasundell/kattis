import kattis.WordsForNumbers
import org.junit.jupiter.api.Test
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