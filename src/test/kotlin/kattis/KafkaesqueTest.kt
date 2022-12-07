package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class KafkaesqueTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Kafkaesque()::solve)
    }

    @Test
    fun two() {
        runTest(2, Kafkaesque()::solve)
    }

    @Test
    fun three() {
        runTest(3, Kafkaesque()::solve)
    }
}