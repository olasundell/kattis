import kattis.Tetris
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class TetrisTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Tetris()::solve)
    }

    @Test
    fun two() {
        runTest(2, Tetris()::solve)
    }

    @Test
    fun three() {
        runTest(3, Tetris()::solve)
    }
}