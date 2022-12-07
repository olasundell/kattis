package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class ElectricalOutletsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, ElectricalOutlets()::solve)
    }
}