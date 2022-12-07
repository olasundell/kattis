package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class FinalExam2Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, FinalExam2()::solve)
    }

    @Test
    fun two() {
        runTest(2, FinalExam2()::solve)
    }
}