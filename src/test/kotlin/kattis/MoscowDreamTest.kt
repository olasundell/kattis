package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class MoscowDreamTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, MoscowDream()::solve)
    }

    @Test
    fun two() {
        runTest(2, MoscowDream()::solve)
    }
}