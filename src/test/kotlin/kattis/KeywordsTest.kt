package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class KeywordsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Keywords()::solve)
    }

    @Test
    fun two() {
        runTest(2, Keywords()::solve)
    }

    @Test
    fun three() {
        runTest(3, Keywords()::solve)
    }
}