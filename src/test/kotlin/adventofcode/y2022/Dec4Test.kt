package adventofcode.y2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.util.*

/**
 * TODO write documentation
 */
class Dec4Test : AbstractKotlinTest() {
	@Test
	fun simpleOne() {
		val s = "2-4,6-8\n" +
				"2-3,4-5\n" +
				"5-7,7-9\n" +
				"2-8,3-7\n" +
				"6-6,4-6\n" +
				"2-6,4-8"

		val r = Dec4().solve(Scanner(s))

		assertEquals("2", r)
	}

	@Test
	fun realOne() {
		runTest(5, Dec4()::solve)
	}

	@Test
	fun realTwo() {
		runTest(5, Dec4(false)::solve)
	}
}