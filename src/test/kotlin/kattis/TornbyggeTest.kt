package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

/**
 * TODO write documentation
 */
internal class TornbyggeTest : AbstractKotlinTest() {
//    @ParameterizedTest
//    @MethodSource("allTestCases")
//    fun all() {
//        runAllTests(Tornbygge()::solve)
//    }
    @Test
    fun one() {
        runTest(1, Tornbygge()::solve)
    }

    @Test
    fun two() {
        runTest(2, Tornbygge()::solve)
    }

    @Test
    fun three() {
        runTest(3, Tornbygge()::solve)
    }

    @Test
    fun four() {
        runTest(4, Tornbygge()::solve)
    }

    @Test
    fun five() {
        runTest(5, Tornbygge()::solve)
    }

    @Test
    fun six() {
        runTest(6, Tornbygge()::solve)
    }

    @Test
    fun seven() {
        runTest(7, Tornbygge()::solve)
    }
}