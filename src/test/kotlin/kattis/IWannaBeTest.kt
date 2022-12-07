package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class IWannaBeTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, IWannaBe()::solve)
    }

    @Test
    fun two() {
        runTest(2, IWannaBe()::solve)
    }

    @Test
    fun three() {
        runTest(3, IWannaBe()::solve)
    }

    @Test
    fun four() {
        runTest(4, IWannaBe()::solve)
    }

    @Test
    fun five() {
        runTest(5, IWannaBe()::solve)
    }
}