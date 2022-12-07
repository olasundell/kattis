package kattis

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
internal class BukaTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, Buka()::solve)
	}
	@Test
	fun two() {
		runTest(2, Buka()::solve)
	}
	@Test
	fun three() {
		runTest(3, Buka()::solve)
	}
	@Test
	fun four() {
		runTest(4, Buka()::solve)
	}
}