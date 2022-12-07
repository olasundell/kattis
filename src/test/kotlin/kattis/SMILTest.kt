package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class SMILTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, SMIL()::solve)
    }

    @Test
    fun two() {
        runTest(2, SMIL()::solve)
    }

    @Test
    fun three() {
        runTest(3, SMIL()::solve)
    }

    @Test
    fun four() {
        runTest(4, SMIL()::solve)
    }
}