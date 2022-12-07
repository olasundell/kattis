package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class CodeToSaveLivesTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, CodeToSaveLives()::solve)
	}
	@Test
	fun two() {
		runTest(2, CodeToSaveLives()::solve)
	}
	@Test
	fun three() {
		runTest(3, CodeToSaveLives()::solve)
	}
}