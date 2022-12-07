package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class DuTubeTest : AbstractKotlinTest() {
	@Test
	fun zero() {
		runTest(0, DuTube()::solve)
	}
	@Test
	fun one() {
		runTest(1, DuTube()::solve)
	}

	@Test
	fun two() {
		runTest(2, DuTube()::solve)
	}
}