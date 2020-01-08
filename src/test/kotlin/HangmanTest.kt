import kattis.Hangman
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class HangmanTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Hangman()::solve)
    }

    @Test
    fun two() {
        runTest(2, Hangman()::solve)
    }

    @Test
    fun three() {
        runTest(3, Hangman()::solve)
    }
}