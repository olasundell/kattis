package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec14Test : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Dec14(1)::solve)
	}

	@Test
	fun two() {
		runTest(2, Dec14(2)::solve)
	}

	@Test
	fun three() {
		runTest(3, Dec14(3)::solve)
	}

	@Test
	fun fourish() {
		runTest(14, Dec14(4)::solve)
	}

	@Test
	fun fiveish() {
		runTest(15, Dec14(40)::solve)
	}

	@Test
	fun four() {
		runTest(4, Dec14(10, true):: solve)
	}

	@Test
	fun five() {
		runTest(5, Dec14(10, true)::solve)
	}

	@Test
	fun freqMap() {
		val freqMap = "ABBCCCDDDDDEEE".groupingBy { it }.eachCount()
//		val m = freqMap.toList().sortedBy { (k, v) -> v }.toMap()
		val m = freqMap.entries.sortedByDescending { it.value }
		m[0].key
	}
}