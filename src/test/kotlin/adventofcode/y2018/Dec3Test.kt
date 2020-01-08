package adventofcode.y2018

import org.junit.jupiter.api.Test
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

    @Test
    fun second() {
        runTest(1, Dec3()::solve2)
    }

//    @Test
//    fun two() {
//        runTest(1, Dec3()::solve2)
//    }
}
