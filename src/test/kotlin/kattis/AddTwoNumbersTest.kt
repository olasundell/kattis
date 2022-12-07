package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class AddTwoNumbersTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, AddTwoNumbers()::solve)
    }
}