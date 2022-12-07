package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class JackOLanternJuxtapositionTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, JackOLanternJuxtaposition()::solve)
    }
    @Test
    fun two() {
        runTest(2, JackOLanternJuxtaposition()::solve)
    }
    @Test
    fun three() {
        runTest(3, JackOLanternJuxtaposition()::solve)
    }
}