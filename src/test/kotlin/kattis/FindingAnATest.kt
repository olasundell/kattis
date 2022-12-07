package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class FindingAnATest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, FindingAnA()::solve)
    }

    @Test
    fun two() {
        runTest(2, FindingAnA()::solve)
    }

    @Test
    fun three() {
        runTest(3, FindingAnA()::solve)
    }
}