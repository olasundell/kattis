package adventofcode.y2019;

import java.lang.IllegalStateException
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec2 {
    fun solve(scanner: Scanner): String {
        val memory = scanner.nextLine().split(",").map { it.toInt() }

        for (i in memory.indices) {
            for (j in memory.indices) {
                if (tryValues(memory, i, j) == 19690720) {
                    return "${i * 100 + j}"
                }
            }
        }

        return "err"
    }

    fun tryValues(memory: List<Int>, one: Int, two: Int): Int {
        val mem = memory.toMutableList()
        mem[1] = one
        mem[2] = two
        return runProgram(mem)
    }

    fun runProgram(memory: MutableList<Int>): Int {
        var ip = 0

        while (ip < memory.size) {

            val opcode = memory[ip]
            val pos1 = memory[ip + 1]
            val pos2 = memory[ip + 2]
            val dest = memory[ip + 3]

            when (opcode) {
                1 -> memory[dest] = memory[pos1] + memory[pos2]
                2 -> memory[dest] = memory[pos1] * memory[pos2]
                99 -> return memory[0]
                else -> throw IllegalStateException("error at $ip, opcode $opcode")
            }
            ip += 4
        }

        return -1
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec2().solve(scanner))
}