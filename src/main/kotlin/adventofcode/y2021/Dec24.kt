package adventofcode.y2021;

import java.security.InvalidParameterException
import java.util.*

/**
 * TODO write documentation
 */
class Dec24(private val inputs: List<Int>) {
	/*
inp a - Read an input value and write it to variable a.
add a b - Add the value of a to the value of b, then store the result in variable a.
mul a b - Multiply the value of a by the value of b, then store the result in variable a.
div a b - Divide the value of a by the value of b, truncate the result to an integer, then store the result in variable a. (Here, "truncate" means to round the value toward zero.)
mod a b - Divide the value of a by the value of b, then store the remainder in variable a. (This is also called the modulo operation.)
eql a b - If the value of a and b are equal, then store the value 1 in variable a. Otherwise, store the value 0 in variable a.
	 */
	fun solve(scanner: Scanner): String {
		val state = solveState(scanner)
		return "$state"
	}

	fun solveState(scanner: Scanner): State {
		var state = State.initial(inputs)

		while (scanner.hasNextLine()) {
			val l = scanner.nextLine().split(" ")
			when (l[0]) {
				"inp" -> state = state.inp(l[1][0])
				"add" -> state = state.add(l[1][0], l[2])
				"mul" -> state = state.mul(l[1][0], l[2])
				"div" -> state = state.div(l[1][0], l[2])
				"mod" -> state = state.mod(l[1][0], l[2])
				"eql" -> state = state.eql(l[1][0], l[2])
			}
		}
		return state
	}

	data class State(val vars: Vars, val inputs: List<Int>) {
		private fun nextInput(): Int = inputs.first()

		fun inp(c: Char): State {
			val v = vars.set(c, nextInput())
			return State(v, inputs.subList(1, inputs.size))
		}

		fun add(a: Char, b: String): State {
			val second = valOrReg(b)

			val v = vars.set(a, vars.get(a) + second)

			return State(v, inputs)
		}

		fun mul(a: Char, b: String): State {
			val second = valOrReg(b)

			val v = vars.set(a, vars.get(a) * second)

			return State(v, inputs)
		}

		fun div(a: Char, b: String): State {
			val second = valOrReg(b)

			val v = vars.set(a, vars.get(a) / second)

			return State(v, inputs)
		}

		fun mod(a: Char, b: String): State {
			val second = valOrReg(b)

			val v = vars.set(a, vars.get(a) % second)

			return State(v, inputs)
		}

		fun eql(a: Char, b: String): State {
			val second = valOrReg(b)

			val v = vars.set(a, if (vars.get(a) == second) 1 else 0)

			return State(v, inputs)
		}

		private fun valOrReg(b: String): Int {
			val second = if (b.matches("[wxyz]".toRegex())) {
				vars.get(b[0])
			} else {
				b.toInt()
			}
			return second
		}

		companion object {
			fun initial(list: List<Int>): State = State(Vars.initial(), list)
		}
	}

	data class Vars(val w: Int, val x: Int, val y: Int, val z: Int) {
		fun get(c: Char): Int =
			when (c) {
				'w' -> this.w
				'x' -> this.x
				'y' -> this.y
				'z' -> this.z
				else -> throw InvalidParameterException("$c is not a valid register")
			}

		fun set(c: Char, value: Int): Vars =
			when (c) {
				'w' -> Vars(value, this.x, this.y, this.z)
				'x' -> Vars(this.w, value, this.y, this.z)
				'y' -> Vars(this.w, this.x, value, this.z)
				'z' -> Vars(this.w, this.x, this.y, value)
				else -> throw InvalidParameterException("$c is not a valid register")
			}

		companion object {
			fun initial() = Vars(0, 0, 0, 0)
		}
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Dec24(listOf(0)).solve(scanner))
}