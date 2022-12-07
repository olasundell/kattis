package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class OverdraftTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Overdraft()::solve)
	}
}