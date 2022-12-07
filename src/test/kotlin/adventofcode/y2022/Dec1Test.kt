package adventofcode.y2022

import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class Dec1Test : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Dec1(1)::solve)
	}

	@Test
	fun two() {
		runTest(2, Dec1(3)::solve)
	}

	@Test
	fun five() {
		runTest(5, Dec1(1)::solve)
	}

	@Test
	fun six() {
		runTest(6, Dec1(3)::solve)
	}
}