package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class LostLineupTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, LostLineup()::solve)
    }

    @Test
    fun two() {
        runTest(2, LostLineup()::solve)
    }

    @Test
    fun three() {
        runTest(3, LostLineup()::solve)
    }
}