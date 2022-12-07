package adventofcode.y2022

import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class Dec6Test : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Dec6()::solve)
	}

	@Test
	fun two() {
		runTest(2, Dec6()::solve)
	}

	@Test
	fun three() {
		runTest(3, Dec6()::solve)
	}

	@Test
	fun four() {
		runTest(4, Dec6()::solve)
	}

	@Test
	fun five() {
		runTest(5, Dec6()::solve)
	}

	@Test
	fun realOne() {
		runTest(6, Dec6()::solve)
	}

	@Test
	fun realTwo() {
		runTest(6, Dec6(14)::solve)
	}
}