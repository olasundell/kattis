import org.junit.Assert.*
import org.junit.Test
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