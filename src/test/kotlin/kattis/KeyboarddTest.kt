package kattis

import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
internal class KeyboarddTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Keyboardd()::solve)
	}

	@Test
	fun two() {
		runTest(2, Keyboardd()::solve)
	}
}