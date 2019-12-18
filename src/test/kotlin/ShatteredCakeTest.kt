import kattis.ShatteredCake
import util.AbstractKotlinTest

import org.junit.Test

class ShatteredCakeTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, ShatteredCake()::solve)
    }
}