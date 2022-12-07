package adventofcode.y2020;

import adventofcode.y2020.MathOp.*
import java.util.*

/**
 * TODO write documentation
 */
class Dec18(private val isTwo: Boolean = false) {
    fun solve(scanner: Scanner): String {
        var total = 0L
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine().replace(" ", "")
            total += eval(line.toCharArray())
        }

        return "$total"
    }

    fun eval(tokens: CharArray): Long {
        val str = shuntYard(tokens)

        return rpnCalculate(str)
    }

    fun shuntYard(tokens: CharArray): String {
        val output = mutableListOf<Token>()
        val operators = ArrayDeque<MathOp>()
        tokens.forEachIndexed { index, c ->
            if (c.isDigit()) {
                output.add(Token(n = (c - '0').toLong()))
            } else {
                val op = when (c) {
                    '*' -> MUL
                    '+' -> ADD
                    '(' -> LEFTP
                    ')' -> RIGHTP
                    else -> throw IllegalStateException("$c is illegal at $index")
                }
                when (op) {
                    LEFTP -> operators.push(LEFTP)
                    RIGHTP -> {
                        while (operators.isNotEmpty() && operators.first() != LEFTP) {
                            output.add(Token(op = operators.pop()))
                        }
                        if (operators.firstOrNull() == LEFTP) {
                            operators.pop()
                        }
                    }
                    MUL -> {
                        while (operators.isNotEmpty() && operators.first() != LEFTP) {
                            output.add(Token(op = operators.pop()))
                        }
                        operators.push(op)
                    }
                    ADD -> {
                        if (isTwo) {
                            while (operators.isNotEmpty() && operators.first() !in setOf(LEFTP, MUL)) {
                                output.add(Token(op = operators.pop()))
                            }
                        } else {
                            while (operators.isNotEmpty() && operators.first() != LEFTP) {
                                output.add(Token(op = operators.pop()))
                            }
                        }
                        operators.push(op)
                    }
                    else -> throw IllegalStateException("$op is illegal at $index")
                }
            }
        }

        while (operators.isNotEmpty()) {
            output.add(Token(op = operators.pop()))
        }

        return output.map { it.toString() }.joinToString(separator = " ")
    }

    fun rpnCalculate(expr: String): Long {
        if (expr.isEmpty()) throw IllegalArgumentException("Expression cannot be empty")
        println("For expression = $expr\n")
//        println("Token           Action             Stack")
        val tokens = expr.split(' ').filter { it != "" }
        val stack = mutableListOf<Double>()
        for (token in tokens) {
            val d = token.toDoubleOrNull()
            if (d != null) {
                stack.add(d)
//                println(" $d   Push num onto top of stack  $stack")
            } else if ((token.length > 1) || (token !in "+-*/^")) {
                throw IllegalArgumentException("$token is not a valid token")
            } else if (stack.size < 2) {
                throw IllegalArgumentException("Stack contains too few operands")
            } else {
                val d1 = stack.removeAt(stack.lastIndex)
                val d2 = stack.removeAt(stack.lastIndex)
                stack.add(
                    when (token) {
                        "+" -> d2 + d1
                        "-" -> d2 - d1
                        "*" -> d2 * d1
                        "/" -> d2 / d1
                        else -> Math.pow(d2, d1)
                    }
                )
//                println(" $token     Apply op to top of stack    $stack")
            }
        }
        return stack[0].toLong()
    }
}

data class Token(val n: Long? = 0, val op: MathOp? = NONE) {
    override fun toString(): String {
        return if (n != 0L) {
            "$n"
        } else {
            when (op) {
                MUL -> "*"
                ADD -> "+"
                LEFTP -> "("
                RIGHTP -> ")"
                NONE -> ""
                else -> throw IllegalStateException("$n $op is illegal")
            }
        }
    }
}

enum class MathOp {
    NONE,
    ADD,
    MUL,
    LEFTP,
    RIGHTP,
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec18(true).solve(scanner))
}