package adventofcode.y2020;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec8 {
    fun solve(scanner: Scanner): String {
        return execute(readInstructions(scanner))
    }

    fun solve2(scanner: Scanner): String {
        val instructions = readInstructions(scanner)
        val jmps = instructions.mapIndexed { index, instruction ->
            instruction to index
        }.filter { it.first.op == Op.jmp }.map { it.second }.toSet()

        jmps.forEach {
            try {
                val instr = instructions.subList(0, it) + Instruction(Op.nop, 0) + instructions.subList(it + 1, instructions.size)
                val result = execute(instr, true)
                return result
            } catch (e: InfiniteLoopException) {
                // ignore
            }
        }

        return "-1"
    }

    private fun execute(instructions: List<Instruction>, failOnLoop: Boolean = false): String {
        val visited = mutableSetOf(0)
        var oldState = State(0, 0)

        while (true) {
            val newState = executeOne(instructions, oldState)

            if (newState.ip >= instructions.size) {
                return "${newState.acc}"
            }

            if (visited.contains(newState.ip)) {
                if (failOnLoop) {
                    throw InfiniteLoopException(newState.ip)
                }
                return "${oldState.acc}"
            }

            visited.add(newState.ip)
            oldState = newState
        }
    }

    class InfiniteLoopException(ip: Int) : Throwable("Infinite loop found at $ip")

    private fun readInstructions(scanner: Scanner): List<Instruction> {
        val instructions = mutableListOf<Instruction>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val instr = Instruction(Op.valueOf(line.substring((0..2))), line.substring(4).toInt())
            instructions.add(instr)
        }
        return instructions.toList()
    }

    fun executeOne(instructions: List<Instruction>, state: State): State {
        val instr = instructions[state.ip]
        return when (instr.op) {
            Op.nop -> state.incIp()
            Op.acc -> state.acc(instr.value)
            Op.jmp -> state.addIp(instr.value)
        }
    }

}

data class State(val acc: Long, val ip: Int)

fun State.addIp(p: Int) = State(this.acc, this.ip + p)
fun State.incIp() = this.addIp(1)
fun State.acc(l: Int) = State(this.acc + l, this.ip + 1)

data class Instruction(val op: Op, val value: Int)

enum class Op {
    nop,
    acc,
    jmp
}

//data class State(val acc: Int, val ip: Int)

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec8().solve(scanner))
}