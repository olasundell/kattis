package codingame

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class LumenTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Lumen()::solve)
	}
}