import kattis.EarlyWinter
import util.AbstractKotlinTest

import org.junit.Test

class EarlyWinterTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, EarlyWinter()::solve)
    }

    @Test
    fun two() {
        runTest(2, EarlyWinter()::solve)
    }

    @Test
    fun three() {
        runTest(3, EarlyWinter()::solve)
    }
}