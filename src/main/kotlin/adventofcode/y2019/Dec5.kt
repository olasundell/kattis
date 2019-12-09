package adventofcode.y2019;

import java.lang.System.err
import java.util.Scanner;
import kotlin.IllegalStateException

/**
 * TODO write documentation
 */
class Dec5 {
    fun solve(scanner: Scanner): String {
        val memory = scanner.nextLine().split(",").map { it.toInt() }

        val memory1 = memory.toMutableList()
        val output = runProgram(memory1, listOf(5))

        return output.joinToString(separator = "\n")
    }

    fun tryValues(memory: List<Int>, one: Int, two: Int): Int {
        val mem = memory.toMutableList()
        mem[1] = one
        mem[2] = two

        return -1
    }


    fun runProgram(memory: MutableList<Int>, input: List<Int>): List<Int> {
        var state = State(memory, 0, listOf(), input)

        while (state.running) {
            state = state.execute()
        }

        return state.output
    }

    class State(
            private val memory: List<Int>,
            private val ip: Int,
            val output: List<Int>,
            private val input: List<Int>,
            val running: Boolean = true
    ) {
        private val opcode: Int = memory[ip]
        private val immPos = ImmPos(opcode)

        fun execute(): State {
            err.println("instruction: $opcode ip: $ip")
            err.println("memory: [${memory.joinToString()}]")
            return when (opcode % 100) {
                1 -> add()
                2 -> mul()
                3 -> store()
                4 -> output()
                5 -> je()
                6 -> jne()
                7 -> lessThan()
                8 -> eq()
                99 -> stop()
                else -> throw IllegalStateException("error at $ip, opcode $opcode")
            }
        }

        private fun stop(): State {
            return State(memory, ip, output, running = false, input = input)
        }

        private fun withValue(idx: Int, value: Int): State {
            val mem = memory.toMutableList()
            mem[idx] = value
            return State(mem, ip, output, input, running)
        }

        fun setIp(ip: Int): State {
            return State(memory, ip, output, input, running)
        }

        fun incIp(increment: Int): State {
            return setIp(ip + increment)
        }

        fun withInput(inp: List<Int>): State {
            return State(memory, ip, output, inp, running)
        }

        /*
         * Opcode 8 is equals: if the first parameter is equal to the second parameter, it stores 1 in the position given by the third parameter.
         * Otherwise, it stores 0.
         */
        private fun eq(): State {
            return withValue(memory[ip + 3], if (first() == second()) 1 else  0).incIp(4)
        }

        /**
         * Opcode 7 is less than: if the first parameter is less than the second parameter, it stores 1 in the position given by the third parameter.
         * Otherwise, it stores 0.
         */

        private fun lessThan(): State = withValue(memory[ip + 3], if (first() < second()) 1 else 0).incIp(4)

        /**
         * Opcode 6 is jump-if-false: if the first parameter is zero, it sets the instruction pointer to the value from the second parameter.
         * Otherwise, it does nothing.
         */

        private fun jne(): State {
            return if (first() == 0) {
                setIp(second())
            } else {
                incIp(3)
            }
        }

        /**
         * Opcode 5 is jump-if-true: if the first parameter is non-zero, it sets the instruction pointer to the value from the second parameter.
         * Otherwise, it does nothing.
         */
        private fun je(): State {
            return if (first() != 0) {
                setIp(second())
            } else {
                incIp(3)
            }
        }

        private fun add(): State {
            val val1 = first()
            val val2 = second()
            val dest = memory[ip + 3]

            return this.withValue(dest, val1 + val2).incIp(4)
        }

        fun mul(): State {
            val val1 = first()
            val val2 = second()
            val dest = memory[ip + 3]

            return this.withValue(dest, val1 * val2).incIp(4)
        }

        // only runs once with 1 as input
        fun store(): State {
            if (input.isEmpty()) {
                throw IllegalStateException("Asked for input when there was none")
            }
            return withValue(memory[ip + 1], input.first()).incIp(2).withInput(input.subList(1, input.size))
        }

        fun output(): State {
            val o = output.plus(first())

            return State(memory, ip + 2, o, input)
        }

        private fun first(): Int {
            return memAt(immPos.first, ip + 1)
        }

        private fun second(): Int {
            return memAt(immPos.second, ip + 2)
        }

        private fun third(): Int {
            return memAt(immPos.third, ip + 3)
        }

        private fun memAt(immediate: Boolean, at: Int): Int {
            return if (immediate) memory[at] else memory[memory[at]]
        }
    }

    class ImmPos(opcode: Int) {
        val first = (opcode / 100 % 10 != 0)
        val second = (opcode / 1_000 % 10 != 0)
        val third = (opcode / 10_000 % 10 != 0)
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec2().solve(scanner))
}
