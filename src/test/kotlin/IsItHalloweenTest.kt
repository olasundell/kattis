import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

class IsItHalloweenTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, IsItHalloween()::solve)
    }

    @Test
    fun two() {
        runTest(2, IsItHalloween()::solve)
    }
}