import kattis.Register
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class RegisterTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Register()::solve)
    }

    @Test
    fun two() {
        runTest(2, Register()::solve)
    }

    @Test
    fun three() {
        runTest(3, Register()::solve)
    }
}