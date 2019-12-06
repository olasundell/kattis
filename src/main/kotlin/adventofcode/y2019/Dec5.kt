package adventofcode.y2019;

import java.lang.IllegalStateException
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec5 {
    val output = mutableListOf<Int>()

    fun solve(scanner: Scanner): String {
        val memory = scanner.nextLine().split(",").map { it.toInt() }

//        for (i in memory.indices) {
//            for (j in memory.indices) {
//                if (tryValues(memory, i, j) == 19690720) {
//                    return "${i * 100 + j}"
//                }
//            }
//        }

        val memory1 = memory.toMutableList()
        runProgram(memory1)

        return output.joinToString(separator = "\n")
//        return "err"
    }

    fun tryValues(memory: List<Int>, one: Int, two: Int): Int {
        val mem = memory.toMutableList()
        mem[1] = one
        mem[2] = two
        return runProgram(mem)
    }

    /*
     * Opcode 5 is jump-if-true: if the first parameter is non-zero, it sets the instruction pointer to the value from the second parameter.
     * Otherwise, it does nothing.
     * Opcode 6 is jump-if-false: if the first parameter is zero, it sets the instruction pointer to the value from the second parameter.
     * Otherwise, it does nothing.
     * Opcode 7 is less than: if the first parameter is less than the second parameter, it stores 1 in the position given by the third parameter.
     * Otherwise, it stores 0.
     * Opcode 8 is equals: if the first parameter is equal to the second parameter, it stores 1 in the position given by the third parameter.
     * Otherwise, it stores 0.
     */

    fun runProgram(memory: MutableList<Int>): Int {
        var ip = 0

        while (ip < memory.size) {

            val opcode = memory[ip]
            val immPos = ImmPos(opcode)
            state = when (opcode % 10) {
                1 -> ip += add(memory, ip, immPos)
                2 -> ip += mul(memory, ip, immPos)
                3 -> ip += store(memory, ip, immPos)
                4 -> ip += output(memory, ip, immPos)
                5 -> ip = je(memory, ip, immPos)
                6 -> ip = jne(memory, ip, immPos)
                7 -> ip = lessThan(memory, ip, immPos)
                8 -> ip = eq(memory, ip, immPos)
                99 -> return memory[0]
//                else -> throw IllegalStateException("error at $ip, opcode $opcode")
                else -> return -1
            }
        }

        return -1
    }

    data class State(val memory: List<Int>, ip: Int, immPos: ImmPos)

    class ImmPos(opcode: Int) {
        val first = (opcode / 100 % 10 != 0)
        val second = (opcode / 1_000 % 10 != 0)
        val third = (opcode / 10_000 % 10 != 0)
    }

    fun mul(memory: MutableList<Int>, ip: Int, immPos: ImmPos): Int {
        val val1 = if (immPos.first) memory[ip + 1] else memory[memory[ip + 1]]
        val val2 = if (immPos.second) memory[ip + 2] else memory[memory[ip + 2]]
        val dest = memory[ip + 3]

        memory[dest] = val1 * val2
        return 4
    }

    fun add(memory: MutableList<Int>, ip: Int, immPos: ImmPos): Int {
        val val1 = if (immPos.first) memory[ip + 1] else memory[memory[ip + 1]]
        val val2 = if (immPos.second) memory[ip + 2] else memory[memory[ip + 2]]
        val dest = memory[ip + 3]

        memory[dest] = val1 + val2
        return 4
    }

    // only runs once with 1 as input
    fun store(memory: MutableList<Int>, ip: Int, immPos: ImmPos): Int {
        memory[memory[ip + 1]] = 1
        return 2
    }

    fun output(memory: MutableList<Int>, ip: Int, immPos: ImmPos): Int {
        output.add(
                if (immPos.first) {
                    memory[ip + 1]
                } else {
                    memory[memory[ip + 1]]
                }
        )
        return 2
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec2().solve(scanner))
}
