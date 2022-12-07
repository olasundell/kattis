package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.awt.Point

/**
 * TODO write documentation
 */
class Dec13Test : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Dec13(true)::solve)
	}

	@Test
	fun five() {
		runTest(5, Dec13(false, true)::solve)
	}

	@Test
	fun fivePrime() {
		runTest(5, Dec13(true)::solve)
	}

	@Test
	fun convertPShouldWork() {
		val dec13 = Dec13(false)
		val p = dec13.convertP(Point(0, 14), Dec13.Fold(axis="y", 7))
		assertEquals(Point(0, 0), p)
		val p2 = dec13.convertP(Point(0, 14), Dec13.Fold(axis="y", 7))
		assertEquals(Point(0, 0), p2)
	}
}