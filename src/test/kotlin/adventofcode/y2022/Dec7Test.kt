package adventofcode.y2022

import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class Dec7Test : AbstractKotlinTest() {
	@Test

	fun one() {
		runTest(1, Dec7()::solve)
	}

	@Test
	fun realOne() {
		runTest(5, Dec7()::solve)
	}

	@Test
	fun realTwo() {
		runTest(5, Dec7()::solve2)
	}
}