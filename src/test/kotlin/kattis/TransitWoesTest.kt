package kattis

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
internal class TransitWoesTest: AbstractKotlinTest() {
    @Test
    fun divide() {
        val w = TransitWoes()

        Assertions.assertEquals(0, w.remainderOrZero(3, 1))

        Assertions.assertEquals(0, w.remainderOrZero(0, 5))
        Assertions.assertEquals(4, w.remainderOrZero(1, 5))
        Assertions.assertEquals(3, w.remainderOrZero(2, 5))
        Assertions.assertEquals(2, w.remainderOrZero(3, 5))
        Assertions.assertEquals(1, w.remainderOrZero(4, 5))
        Assertions.assertEquals(0, w.remainderOrZero(5, 5))
        Assertions.assertEquals(1, w.remainderOrZero(9, 5))
        Assertions.assertEquals(1, w.remainderOrZero(29, 5))
    }
    @Test
    fun one() {
        runTest(1, TransitWoes()::solve)
    }

    @Test
    fun two() {
        runTest(2, TransitWoes()::solve)
    }
}