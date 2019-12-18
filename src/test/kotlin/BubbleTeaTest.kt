import kattis.BubbleTea
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class BubbleTeaTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, BubbleTea()::solve)
    }

    @Test
    fun two() {
        runTest(2, BubbleTea()::solve)
    }

    @Test
    fun three() {
        runTest(3, BubbleTea()::solve)
    }
 }