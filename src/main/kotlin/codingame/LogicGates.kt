package codingame;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class LogicGates {
	fun solve(input: Scanner): String {
		val n = input.nextInt()
		val m = input.nextInt()
		val signals = (0 until n).map {
			val inputName = input.next()
			val inputSignal = input.next().map { it == '-' }
			inputName to InputSignal(inputName, inputSignal)
		}.toMap()

		val output = (0 until m).map {
			val outputName = input.next()
			val type = input.next()
			val inputName1 = input.next()
			val inputName2 = input.next()
			OutputSignal(outputName, SignalType.valueOf(type), inputName1, inputName2)
		}.map {
			val s = signals[it.one]!!.signal
				.mapIndexed { index, b -> it.type.op(b, signals[it.two]!!.signal[index]) }
				.map { if (it) '-' else '_' }
				.joinToString("")
			"${it.name} ${s}"
		}

		return output.joinToString("\n")
	}
}

enum class SignalType(val op: (a: Boolean, b: Boolean) -> Boolean) {
	AND({ a, b -> a && b }),
	OR({ a, b -> a || b }),
	XOR({ a, b -> a.xor(b) }),
	NAND({ a, b -> !(a && b) }),
	NOR({ a, b -> !(a || b) }),
	NXOR({ a, b -> !(a.xor(b)) })
}

data class InputSignal(val name: String, val signal: List<Boolean>)
data class OutputSignal(val name: String, val type: SignalType, val one: String, val two: String)

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(LogicGates().solve(scanner))
}