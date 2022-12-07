package codingame;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class `1DSpreadSheet` {
	fun solve(scanner: Scanner): String {
		val n = scanner.nextInt()
		scanner.nextLine()
		val ops = (0 until n).mapIndexed { i, _ ->
			scanner.nextLine().toOp(i)
		}.toMutableList()

		val sheet = (0 until n).map { 0 }.toMutableList()

		ops.forEachIndexed { index, ssOp -> sheet[index] = ssOp.calc(ops, sheet) }

		return sheet.joinToString("\n")
	}
}

data class SSOp(val op: String, val args: List<String>, val idx: Int) {
	fun value(): Int = if (op == "VALUE") args[0].toInt() else 0

	fun calc(ops: MutableList<SSOp>, sheet: List<Int>): Int {
		if (op == "VALUE") return arg(args[0], ops, sheet)

		val v = when (op) {
			"ADD" -> arg(args[0], ops, sheet) + arg(args[1], ops, sheet)
			"SUB" -> arg(args[0], ops, sheet) - arg(args[1], ops, sheet)
			"MULT" -> arg(args[0], ops, sheet) * arg(args[1], ops, sheet)
			else -> throw IllegalArgumentException("Unknown op: $op")
		}

		ops[idx] = SSOp("VALUE", listOf(v.toString()), idx)

		return v
	}

	private fun arg(a: String, ops: MutableList<SSOp>, sheet: List<Int>): Int =
		if (a.startsWith("$")) {
			ops[a.substring(1).toInt()].calc(ops, sheet)
		} else {
			a.toInt()
		}
}

private fun String.toOp(idx: Int) = SSOp(this.substringBefore(" "), this.substringAfter(" ").split(" "), idx)

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(`1DSpreadSheet`().solve(scanner))
}