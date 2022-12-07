package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class FiftyShadesTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, FiftyShades()::solve)
    }

    @Test
    fun two() {
        runTest(2, FiftyShades()::solve)
    }
}