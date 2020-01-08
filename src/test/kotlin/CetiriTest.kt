import kattis.Cetiri
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class CetiriTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Cetiri()::solve);
    }

    @Test
    fun two() {
        runTest(2, Cetiri()::solve);
    }

    @Test
    fun three() {
        runTest(3, Cetiri()::solve);
    }

    @Test
    fun four() {
        runTest(4, Cetiri()::solve);
    }

    @Test
    fun five() {
        runTest(5, Cetiri()::solve);
    }
}