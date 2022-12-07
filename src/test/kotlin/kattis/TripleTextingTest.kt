package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class TripleTextingTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, TripleTexting()::solve)
	}

	@Test
	fun two() {
		runTest(2, TripleTexting()::solve)
	}
}