package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class CinemaTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Cinema()::solve)
	}

	@Test
	fun two() {
		runTest(2, Cinema()::solve)
	}
}