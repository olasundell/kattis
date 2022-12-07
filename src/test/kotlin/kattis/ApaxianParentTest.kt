package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class ApaxianParentTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, ApaxianParent()::solve)
    }

    @Test
    fun two() {
        runTest(2, ApaxianParent()::solve)
    }

    @Test
    fun three() {
        runTest(3, ApaxianParent()::solve)
    }

    @Test
    fun four() {
        runTest(4, ApaxianParent()::solve)
    }
}