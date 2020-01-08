import kattis.Sort
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class SortTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Sort()::solve)
    }

    @Test
    fun two() {
        runTest(2, Sort()::solve)
    }

    @Test
    fun three() {
        runTest(3, Sort()::solve)
    }

}