import kattis.EenyMeeny
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class EenyMeenyTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, EenyMeeny()::solve)
    }

    @Test
    fun two() {
        runTest(2, EenyMeeny()::solve)
    }

    @Test
    fun three() {
        runTest(3, EenyMeeny()::solve)
    }

    @Test
    fun four() {
        runTest(4, EenyMeeny()::solve)
    }
}