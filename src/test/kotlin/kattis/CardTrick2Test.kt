package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class CardTrick2Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, CardTrick2()::solve)
    }
}