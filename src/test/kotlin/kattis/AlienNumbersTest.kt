package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class AlienNumbersTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, AlienNumbers()::solve)
	}
}