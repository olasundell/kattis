import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

class ShatteredCakeTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, ShatteredCake()::solve)
    }
}