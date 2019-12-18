package adventofcode.y2019;

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.runBlocking
import java.lang.System.err
import java.util.Scanner;
import kotlin.IllegalStateException

/**
 * TODO write documentation
 */
class Dec5 {
//    val memStates: MutableList<Map<Long, Long>> = mutableListOf()

    fun solve(scanner: Scanner): String {
        val memory = scanner.nextLine().split(",").map { it.toLong() }

        var output: String = "-1"
        runBlocking {
            output = runProgram(memory, listOf(5))
        }

//        return output.joinToString(separator = "\n")
        return output
    }

    fun tryValues(memory: List<Int>, one: Int, two: Int): Int {
        val mem = memory.toMutableList()
        mem[1] = one
        mem[2] = two

        return -1
    }

    suspend fun runProgram(memory: List<Long>, input: List<Int>): String {
        val output = Channel<Long>(capacity = Int.MAX_VALUE)
        val inputC = Channel<Long>(capacity = Int.MAX_VALUE)
        var state = State("", memory, Ip(0, 0), inputC, output, true)

        input.forEach { inputC.offer(it.toLong()) }
//        memStates.add(state.memory)

        while (state.running) {
            state = state.execute()
//            memStates.add(state.memory)
        }
        var n: Long?
        val list = mutableListOf<Long>()
        do {
            n = state.output.poll()
            if (n == null) {
                break
            } else {
                list.add(n)
            }
        }  while (true)

//        return state.output.poll() ?: 0
        return list.map{ it.toString()}.joinToString(separator = ",")
    }

    class State(
            private val name: String,
            val memory: Map<Long, Long>,
            private val ip: Ip,
            private val input: Channel<Long>,
            val output: Channel<Long>,
            val running: Boolean
    ) {
        constructor (
                name: String,
                memory: List<Long>,
                ip: Ip,
                input: Channel<Long>,
                output: Channel<Long>,
                running: Boolean
        ): this(name, memory.mapIndexed { idx, i -> idx.toLong() to i }.toMap(), ip, input, output, running)

        private val opcode: Long = memory[ip.ip]!!
        private val immPos = ParamMode(opcode)

        suspend fun execute(): State {
//            err.println("$name instruction: $opcode ip: $ip ${first()} ${second()} ${third()}")
            val state = when ((opcode % 100).toInt()) {
                1 -> withValue(pointer(3), first() + second()).incIp(4)
                2 -> withValue(pointer(3), first() * second()).incIp(4)
//                3 -> withValue(memory[ip + 1]!!, input.receive()).incIp(2)
                3 -> withValue(pointer(1), input.receive()).incIp(2)
                4 -> {
                    output.send(first())
                    incIp(2)
                }
                5 -> if (first() != 0L) setIp(second()) else incIp(3)
                6 -> if (first() == 0L) setIp(second()) else incIp(3)
                7 -> withValue(pointer(3), if (first() < second()) 1 else 0).incIp(4)
                8 -> withValue(pointer(3), if (first() == second()) 1 else  0).incIp(4)
                9 -> adjustBase(first()).incIp(2)
                99 -> State(name, memory, ip, input, output, running = false)
                else -> throw IllegalStateException("error at $ip, opcode $opcode")
            }

//            err.println("memory: [${state.memory.joinToString()}]")

            return state
        }

        private fun adjustBase(delta: Long): State = State(name, memory, Ip(ip.ip, ip.relBase + delta), input, output, running)
        fun setIp(newIp: Long): State = State(name, memory, Ip(newIp, ip.relBase), input, output, running)
        fun incIp(increment: Long): State = setIp(ip + increment)

        private fun withValue(idx: Long, value: Long): State {
            val mem = memory.toMutableMap()
            mem[idx] = value
            return State(name, mem, ip, input, output, running)
        }

        private fun first(): Long = memAt(immPos.first, ip + 1)
        private fun second(): Long = memAt(immPos.second, ip + 2)
        private fun third(): Long = memAt(immPos.third, ip + 3)

        private fun memAt(mode: Mode, at: Long): Long = memory[pointer(mode, at)] ?: 0
        private fun pointer(i: Int): Long = pointer(immPos[i], ip + i)

        private fun pointer(mode: Mode, at: Long): Long =
            when (mode) {
                Mode.POSITION -> memory[at] ?: 0L
                Mode.IMMEDIATE -> at
                Mode.RELATIVE -> (memory[at] ?: 0).plus(ip.relBase)
            }

    }

    data class Ip(val ip: Long, val relBase: Long) {
        operator fun plus(delta: Int): Long = ip + delta
        operator fun plus(delta: Long): Long = ip + delta
    }

    class ParamMode(opcode: Long) {
//        this[ip] % 1000 / 100
//        this[ip] % 10000 / 1000
//        this[ip] / 10000
//        val first = Mode.from((opcode / 100L) % 10L)
//        val second = Mode.from((opcode / 1_000L) % 10L)
//        val third = Mode.from((opcode / 10_000L) % 10L)
        val first = Mode.from(opcode % 1_000 / 100)
        val second = Mode.from(opcode % 10_000 / 1_000)
        val third = Mode.from(opcode / 10_000)
        operator fun get(i: Int): Mode =
                when(i) {
                    1 -> first
                    2 -> second
                    3 -> third
                    else -> throw IllegalArgumentException("$i is invalid")
                }
    }

    enum class Mode {
        POSITION,
        IMMEDIATE,
        RELATIVE;

        companion object {
            fun from(p: Long): Mode {
                return when (p) {
                    0L -> POSITION
                    1L -> IMMEDIATE
                    2L -> RELATIVE
                    else -> throw IllegalArgumentException("$p is invalid")
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec5().solve(scanner))
}
