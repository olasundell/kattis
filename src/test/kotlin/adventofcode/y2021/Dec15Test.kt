package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec15Test : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Dec15()::solve)
	}
}