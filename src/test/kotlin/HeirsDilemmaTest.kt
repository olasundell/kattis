import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class HeirsDilemmaTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, HeirsDilemma()::solve)
    }

    @Test
    fun two() {
        runTest(2, HeirsDilemma()::solve)
    }

    @Test
    fun three() {
        runTest(3, HeirsDilemma()::solve)
    }
}