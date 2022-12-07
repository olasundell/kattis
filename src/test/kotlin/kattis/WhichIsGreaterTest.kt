package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class WhichIsGreaterTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, WhichIsGreater()::solve)
	}

	@Test
	fun two() {
		runTest(2, WhichIsGreater()::solve)
	}

	@Test
	fun three() {
		runTest(3, WhichIsGreater()::solve)
	}
}