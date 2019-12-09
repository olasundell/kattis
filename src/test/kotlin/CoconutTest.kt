import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class CoconutTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Coconut()::solve)
    }

    @Test
    fun two() {
        runTest(2, Coconut()::solve)
    }

    @Test
    fun three() {
        runTest(3, Coconut()::solve)
    }
}