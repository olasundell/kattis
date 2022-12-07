package codingame

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class RetroTypewriterArtTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, RetroTypewriterArt()::solve)
	}

	@Test
	fun two() {
		runTest(2, RetroTypewriterArt()::solve)
	}
}