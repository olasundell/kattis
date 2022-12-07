package adventofcode.y2022

import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.util.*
import kotlin.test.assertEquals

/**
 * TODO write documentation
 */
class Dec2Test : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Dec2()::solve)
	}

	@Test
	fun two() {
		val a = Dec2(true).solve(Scanner("A Y"))
		assertEquals("4", a)

		val b = Dec2(true).solve(Scanner("B X"))
		assertEquals("1", b)

		val c = Dec2(true).solve(Scanner("C Z"))
		assertEquals("7", c)

		runTest(2, Dec2(true)::solve)
	}

	@Test
	fun realOne() {
		runTest(5, Dec2()::solve)
	}

	@Test
	fun realTwo() {
		runTest(5, Dec2(true)::solve)
	}
}