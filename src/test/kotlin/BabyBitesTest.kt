import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class BabyBitesTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, BabyBites()::solve)
    }

    @Test
    fun two() {
        runTest(2, BabyBites()::solve)
    }

    @Test
    fun three() {
        runTest(3, BabyBites()::solve)
    }
}