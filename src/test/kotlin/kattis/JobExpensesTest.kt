package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class JobExpensesTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, JobExpenses()::solve)
    }

    @Test
    fun two() {
        runTest(2, JobExpenses()::solve)
    }

    @Test
    fun three() {
        runTest(3, JobExpenses()::solve)
    }
}