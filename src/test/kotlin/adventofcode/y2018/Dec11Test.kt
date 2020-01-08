package adventofcode.y2018

import org.junit.jupiter.api.Assertions
import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Dec11Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec11()::solve)
    }

    @Test
    fun two() {
        runTest(2, Dec11()::solve2)
    }

    @Test
    fun three() {
        runTest(3, Dec11()::solve2)
    }

    @Test
    fun four() {
        runTest(4, Dec11()::solve2)
    }

    @Test
    fun initTest() {
        Assertions.assertEquals(-5, Dec11().init(122, 79, 57))
        Assertions.assertEquals(0, Dec11().init(217, 196, 39))
        Assertions.assertEquals(4, Dec11().init(101, 153, 71))
    }
}