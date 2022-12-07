package kattis;

import java.util.*

/**
 * TODO write documentation
 */
class Keyboardd {
	fun solve(scanner: Scanner): String {
		val orig = scanner.nextLine()
		val dupl = scanner.nextLine()
		val keys = mutableListOf<Char>()

		orig.forEachIndexed { index, c ->
			println(orig.mapIndexed { idx, c -> if (idx == index) c.uppercaseChar() else c }.joinToString(separator=""))
			println(dupl.mapIndexed { idx, c -> if (idx == i(index, keys)) c.uppercaseChar() else c }.joinToString(separator=""))
			println("----------------------")
			if (c != dupl[i(index, keys)]) {
				keys.add(dupl[i(index, keys)])
			}
			if (c != dupl[i(index, keys)]) {
				println(orig.mapIndexed { idx, c -> if (idx == index) c.uppercaseChar() else c }.joinToString(separator=""))
				println(dupl.mapIndexed { idx, c -> if (idx == i(index, keys)) c.uppercaseChar() else c }.joinToString(separator=""))
				println("=====================")
				keys.add(dupl[i(index, keys)])
			}
		}

		return keys.toSet().joinToString(separator = "")
	}

//	private fun i(index: Int, keys: MutableList<Char>) = index + keys.size * 2
	private fun i(index: Int, keys: MutableList<Char>) = index + keys.size
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Keyboardd().solve(scanner))
}