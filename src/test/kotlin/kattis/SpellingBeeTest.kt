package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class SpellingBeeTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, SpellingBee()::solve)
    }
}