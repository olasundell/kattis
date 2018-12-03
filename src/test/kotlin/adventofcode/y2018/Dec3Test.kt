package adventofcode.y2018

import org.junit.Test
import util.AbstractKotlinTest

class Dec3Test: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec3()::solve)
    }

    @Test
    fun two() {
        runTest(2, Dec3()::solve)
    }

//    @Test
//    fun two() {
//        runTest(1, Dec3()::solve2)
//    }
}
