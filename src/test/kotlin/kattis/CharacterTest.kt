package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class CharacterTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Character()::solve)
    }

    @Test
    fun two() {
        runTest(2, Character()::solve)
    }
}