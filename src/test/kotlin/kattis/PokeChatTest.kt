package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class PokeChatTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, PokeChat()::solve)
	}

	@Test
	fun two() {
		runTest(2, PokeChat()::solve)
	}
}