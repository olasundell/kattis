package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class Greetings2Test : AbstractKotlinTest() {
    @Test
    fun three() {
        runTest(3, Greetings2()::solve)
    }

    @Test
    fun seven() {
        runTest(7, Greetings2()::solve)
    }
}