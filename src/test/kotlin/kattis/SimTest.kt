package kattis

import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
internal class SimTest: AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Sim()::solve)
	}

	@Test
	fun two() {
		runTest(2, Sim()::solve)
	}

	@Test
	fun three() {
		runTest(3, Sim()::solve)
	}

	@Test
	fun four() {
		runTest(4, Sim()::solve)
	}
}