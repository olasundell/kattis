package adventofcode.y2021

import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.util.*
import kotlin.test.assertEquals

/**
 * TODO write documentation
 */
class Dec24Test : AbstractKotlinTest() {
	@Test
	fun invert() {
		val f = Dec24(listOf(3)).solveState(
			Scanner(
				"inp x\n" +
						"mul x -1"
			)
		)

		assertEquals(-3, f.vars.x)
	}

	@Test
	fun oneIfDivisibleByThree() {
		val ops = "inp z\n" +
				"inp x\n" +
				"mul z 3\n" +
				"eql z x"

		val f = Dec24(listOf(3, 9)).solveState(Scanner(ops))

		assertEquals(1, f.vars.z)

		val g = Dec24(listOf(3, 8)).solveState(Scanner(ops))

		assertEquals(0, g.vars.z)
	}

	@Test
	fun convertToBinary() {
		val ops = "inp w\n" +
				"add z w\n" +
				"mod z 2\n" +
				"div w 2\n" +
				"add y w\n" +
				"mod y 2\n" +
				"div w 2\n" +
				"add x w\n" +
				"mod x 2\n" +
				"div w 2\n" +
				"mod w 2"

		val f = Dec24(listOf(1)).solveState(Scanner(ops))

		assertEquals(1, f.vars.z)
		assertEquals(0, f.vars.y)
		assertEquals(0, f.vars.x)
		assertEquals(0, f.vars.w)

		val g = Dec24(listOf(9)).solveState(Scanner(ops))

		assertEquals(1, g.vars.z)
		assertEquals(0, g.vars.y)
		assertEquals(0, g.vars.x)
		assertEquals(1, g.vars.w)
	}

	@Test
	fun one() {
		val ops = "inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 1\n" +
				"add x 13\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 13\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 1\n" +
				"add x 11\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 10\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 1\n" +
				"add x 15\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 5\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 26\n" +
				"add x -11\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 14\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 1\n" +
				"add x 14\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 5\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 26\n" +
				"add x 0\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 15\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 1\n" +
				"add x 12\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 4\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 1\n" +
				"add x 12\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 11\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 1\n" +
				"add x 14\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 1\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 26\n" +
				"add x -6\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 15\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 26\n" +
				"add x -10\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 12\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 26\n" +
				"add x -12\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 8\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 26\n" +
				"add x -3\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 14\n" +
				"mul y x\n" +
				"add z y\n" +
				"inp w\n" +
				"mul x 0\n" +
				"add x z\n" +
				"mod x 26\n" +
				"div z 26\n" +
				"add x -5\n" +
				"eql x w\n" +
				"eql x 0\n" +
				"mul y 0\n" +
				"add y 25\n" +
				"mul y x\n" +
				"add y 1\n" +
				"mul z y\n" +
				"mul y 0\n" +
				"add y w\n" +
				"add y 9\n" +
				"mul y x\n" +
				"add z y"

		var z = -1

		val l = arrayOf(9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9)

		while (z != 0) {
			val f = Dec24(l.toList()).solveState(Scanner(ops))
			decr(l)
			z = f.vars.z
		}

		assertEquals(0, z)
	}

	private fun decr(l: Array<Int>) {
		l[12] = l[12] - 1
		if (l[12] == 0) {
			l[11] = l[11] - 1
			l[12] = 9
		}
	}
}