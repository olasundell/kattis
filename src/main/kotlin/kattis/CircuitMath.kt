package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class CircuitMath {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()
        val chars = readValues(scanner.nextLine().split(" "))

        val line = scanner.nextLine()

        val r = rpnCalculate(line, chars)

        return if (r) { "T" } else { "F" }
    }

//    private fun readValues(l: List<String>): Map<Char, Boolean> = l.mapIndexed { index, s -> ('A' + index) to (s == "T") }.toMap()
    private fun readValues(l: List<String>): Map<String, String> = l.mapIndexed { index, s -> ('A' + index).toString() to s }.toMap()

    fun rpnCalculate(expr: String, chars: Map<String, String>): Boolean {
        if (expr.isEmpty()) throw IllegalArgumentException("Expression cannot be empty")
        println("For expression = $expr\n")
//        println("Token           Action             Stack")
        val tokens = expr.split(' ').filter { it != "" }.map { if (it[0].isLetter()) { chars[it]!! } else { it } }
        println("With tokens = $tokens\n")

        val stack = mutableListOf<Boolean>()
        for (token in tokens) {
            val d = if (token.matches(Regex("[TF]"))) {
                token == "T"
            } else {
                null
            }
            if (d != null) {
                stack.add(d)
                println(" $d   Push num onto top of stack  $stack")
            } else if ((token.length > 1) || (token !in "+-*TF")) {
                throw IllegalArgumentException("$token is not a valid token")
            } else if (stack.size < 1) {
                throw IllegalArgumentException("Stack contains too few operands")
            } else if (token == "-") {
                val d1 = stack.removeAt(stack.lastIndex)
                stack.add(!d1)
            } else {
                val d1 = stack.removeAt(stack.lastIndex)
                val d2 = stack.removeAt(stack.lastIndex)
                stack.add(
                    when (token) {
                        "*" -> d2 && d1
                        "+" -> d2 || d1
                        else -> throw IllegalStateException("Illegal state, ${d1} ${d2} ${token}")
                    }
                )
//                println(" $token     Apply op to top of stack    $stack")
            }
        }
        return stack[0]
    }
}

private fun String.isOperator(): Boolean = matches(Regex("[*+-]"))

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(CircuitMath().solve(scanner))
}