import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class KleptographyTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Kleptography()::solve)
    }

    @Test
    fun two() {
        runTest(2, Kleptography()::solve)
    }
}