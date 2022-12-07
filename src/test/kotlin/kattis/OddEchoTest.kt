package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class OddEchoTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, OddEcho()::solve)
    }

    @Test
    fun two() {
        runTest(2, OddEcho()::solve)
    }
}