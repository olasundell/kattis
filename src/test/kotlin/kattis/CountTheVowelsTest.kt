package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class CountTheVowelsTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, CountTheVowels()::solve)
	}

	@Test
	fun two() {
		runTest(2, CountTheVowels()::solve)
	}

	@Test
	fun three() {
		runTest(3, CountTheVowels()::solve)
	}

	@Test
	fun four() {
		runTest(4, CountTheVowels()::solve)
	}
}