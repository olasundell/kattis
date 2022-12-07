package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class ProofsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Proofs()::solve)
    }

    @Test
    fun two() {
        runTest(2, Proofs()::solve)
    }

    @Test
    fun three() {
        runTest(3, Proofs()::solve)
    }

    @Test
    fun four() {
        runTest(4, Proofs()::solve)
    }
}