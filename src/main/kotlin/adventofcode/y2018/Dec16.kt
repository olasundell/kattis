package adventofcode.y2018;

import java.lang.System.out
import java.util.Scanner;


class Dec16 {
    private val listOfInstructions = listOf<Instruction>(Addr(), Addi(), Mulr(), Muli(), Banr(), Bani(), Borr(), Bori(), Setr(), Seti(), Gtir(), Gtri(), Gtrr())

    fun solve(scanner: Scanner): String {
        var threeOrMore = 0
        while (scanner.hasNextLine()) {
            var matching = 0
            val before = readState(scanner.nextLine())
            val (opcode, a, b, c) = scanner.nextLine().split(" ").map { it.toInt() }
            val operand = Operand(opcode, a, b, c)
            val after = readState(scanner.nextLine())

            for (instr in listOfInstructions) {
                if (instr.apply(before, operand.a, operand.b, operand.c) == after) {
                    matching++
                }
            }

            if (scanner.hasNextLine()) {
                scanner.nextLine()
            }

            if (matching != 0) {
                out.println()
            }

            if (matching >= 3) {
                threeOrMore++
            }
        }

        return threeOrMore.toString()
    }

    private fun readState(nextLine: String): State {
        val (zero, one, two, three) = nextLine.replace("]", "").split("[")[1].split(", ").map { it.toInt() }

        return State(Registers(zero, one, two, three))
    }
}

data class Operand(val opcode: Int, val a: Int, val b: Int, val c: Int)

interface Instruction {
    fun apply(state: State, a: Int, b: Int, c: Int): State
}

/**
 * Addition:
 *
 * addr (add register) stores into register C the result of adding register A and register B.
 */

class Addr: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a) + state.registers.get(b)))
}

/**
 * addi (add immediate) stores into register C the result of adding register A and value B.
 */
class Addi: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a) + b))
}

/**
 * Multiplication:
 *
 * mulr (multiply register) stores into register C the result of multiplying register A and register B.
 */

class Mulr: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a) * state.registers.get(b)))
}

/**
 * muli (multiply immediate) stores into register C the result of multiplying register A and value B.
 */
class Muli: Instruction  {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a) * b))
}

/**
 * Bitwise AND:
 *
 * banr (bitwise AND register) stores into register C the result of the bitwise AND of register A and register B.
 */

class Banr: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a) and state.registers.get(b)))
}

/**
 * bani (bitwise AND immediate) stores into register C the result of the bitwise AND of register A and value B.
 */
class Bani: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a) and b))
}

/**
 * Bitwise OR:
 *
 * borr (bitwise OR register) stores into register C the result of the bitwise OR of register A and register B.
 */

class Borr: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a) or state.registers.get(b)))
}

/**
 * bori (bitwise OR immediate) stores into register C the result of the bitwise OR of register A and value B.
 */
class Bori: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a) or b))
}

/**
 * Assignment:
 *
 * setr (set register) copies the contents of register A into register C. (Input B is ignored.)
 */

class Setr: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, state.registers.get(a)))
}

/**
 * seti (set immediate) stores value A into register C. (Input B is ignored.)
 */
class Seti: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State = State(state.registers.set(c, a))
}

/**
 * Greater-than testing:
 *
 * gtir (greater-than immediate/register) sets register C to 1 if value A is greater than register B. Otherwise, register C is set to 0.
 */
class Gtir: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State {
        return State(state.registers.set(c,
                if (a > state.registers.get(b)) {
                    1
                } else {
                    0
                }
        ))
    }
}

/**
 * gtri (greater-than register/immediate) sets register C to 1 if register A is greater than value B. Otherwise, register C is set to 0.
 */
class Gtri: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State {
        return State(state.registers.set(c,
                if (state.registers.get(a) > b) {
                    1
                } else {
                    0
                }
        ))
    }
}

/**
 * gtrr (greater-than register/register) sets register C to 1 if register A is greater than register B. Otherwise, register C is set to 0.
 */
class Gtrr: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State {
        return State(state.registers.set(c,
                if (state.registers.get(a) > state.registers.get(b)) {
                    1
                } else {
                    0
                }
        ))
    }
}

/**
 * Equality testing:
 *
 * eqir (equal immediate/register) sets register C to 1 if value A is equal to register B. Otherwise, register C is set to 0.
 */

class Eqir: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State {
        return State(state.registers.set(c,
                if (a == state.registers.get(b)) 1 else 0
        ))
    }
}

/**
 * eqri (equal register/immediate) sets register C to 1 if register A is equal to value B. Otherwise, register C is set to 0.
 */
class Eqri: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State {
        return State(state.registers.set(c,
                if (state.registers.get(a) == b) 1 else 0
        ))
    }
}

/**
 * eqrr (equal register/register) sets register C to 1 if register A is equal to register B. Otherwise, register C is set to 0.
 */
class Eqrr: Instruction {
    override fun apply(state: State, a: Int, b: Int, c: Int): State {
        return State(state.registers.set(c,
                if (state.registers.get(a) == state.registers.get(b)) 1 else 0
        ))
    }
}

data class Registers(val zero: Int, val one: Int, val two: Int, val three: Int) {
    override fun equals(other: Any?): Boolean {
        super.equals(other)
        if (other == null || other !is Registers) {
            return false
        }

        return other.one == this.one && other.two == this.two && other.three == this.three && other.zero == this.zero
    }

    fun get(reg: Int): Int {
        return when (reg) {
            0 -> zero
            1 -> one
            2 -> two
            3 -> three
            else -> throw IllegalArgumentException("$reg is not a valid register")
        }
    }

    fun set(reg: Int, value: Int): Registers {
        return when (reg) {
            0 -> Registers(value, one, two, three)
            1 -> Registers(zero, value, two, three)
            2 -> Registers(zero, one, value, three)
            3 -> Registers(zero, one, two, value)
            else -> throw IllegalArgumentException("$reg is not a valid register")
        }
    }
}

data class State(val registers: Registers)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec16().solve(scanner))
}