package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class LaptopStickerTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, LaptopSticker()::solve)
    }

    @Test
    fun two() {
        runTest(2, LaptopSticker()::solve)
    }

    @Test
    fun three() {
        runTest(3, LaptopSticker()::solve)
    }
}