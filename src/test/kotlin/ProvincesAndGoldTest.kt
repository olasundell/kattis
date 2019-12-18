import kattis.ProvincesAndGold
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class ProvincesAndGoldTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, ProvincesAndGold()::solve)
    }

    @Test
    fun two() {
        runTest(2, ProvincesAndGold()::solve)
    }

    @Test
    fun three() {
        runTest(3, ProvincesAndGold()::solve)
    }
}