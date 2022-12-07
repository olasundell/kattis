package adventofcode.y2022

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.util.*

/**
 * TODO write documentation
 */
class Dec3Test : AbstractKotlinTest() {
	val s = "vJrwpWtwJgWrhcsFMMfFFhFp\n" +
			"jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL\n" +
			"PmmdzqPrVvPwwTWBwg\n" +
			"wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn\n" +
			"ttgJtRGJQctTZtZT\n" +
			"CrZsJsPPZsGzwwsLwLmpwMDw"

	@Test
	fun one() {
		val a = Dec3().solve(Scanner(s))

		assertEquals("157", a)
	}

	@Test
	fun two() {
		val a = Dec3().solve2(Scanner(s))

		assertEquals("70", a)
	}

	@Test
	fun realOne() {
		runTest(5, Dec3()::solve)
	}

	@Test
	fun realTwo() {
		runTest(5, Dec3()::solve2)
	}
}