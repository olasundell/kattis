package adventofcode.y2019

import java.lang.System.err
import kotlin.system.exitProcess
import java.lang.Math.toIntExact as int

/**
 * TODO write documentation
 */
class IntMachine(private val memory: List<Long>, private val arg: Long) {

    fun intMachine(): List<List<Long>> {
        val mem = memory.toMutableList()
        var sep = ""
        val memIterations = mutableListOf<List<Long>>()
        var rb = 0
        var ip = 0

        do {
            memIterations.add(mem.toList())
            err.println("instruction: ${mem[ip]} ip: Ip(ip=$ip, relBase=$rb) ${mem[ip, rb, 1]} ${mem[ip, rb, 2]} ${mem[ip, rb, 3]}")
            when (val opcode = mem[ip] % 100) {
                1L -> {
                    mem[ip, rb, 3] = Math.addExact(mem[ip, rb, 1], mem[ip, rb, 2])
                    ip += 4
                }
                2L -> {
                    mem[ip, rb, 3] = Math.multiplyExact(mem[ip, rb, 1], mem[ip, rb, 2])
                    ip += 4
                }
                3L -> {
                    mem[ip, rb, 1] = arg
                    ip += 2
                }
                4L -> {
                    print("$sep${mem[ip, rb, 1]}")
                    sep = ","
                    ip += 2
                }
                5L -> {
                    if (mem[ip, rb, 1] != 0L) ip = int(mem[ip, rb, 2])
                    else ip += 3
                }
                6L -> {
                    if (mem[ip, rb, 1] == 0L) ip = int(mem[ip, rb, 2])
                    else ip += 3
                }
                7L -> {
                    mem[ip, rb, 3] = if (mem[ip, rb, 1] < mem[ip, rb, 2]) 1 else 0
                    ip += 4
                }
                8L -> {
                    mem[ip, rb, 3] = if (mem[ip, rb, 1] == mem[ip, rb, 2]) 1 else 0
                    ip += 4
                }
                9L -> {
                    rb += int(mem[ip, rb, 1])
                    ip += 2
                }
                99L -> {
                    println()
//                    exitProcess(0)
                    return memIterations
                }
                else -> error("Unknown Opcode $opcode (ins=${mem[ip]}, ip=$ip)")
            }
        } while (true)

        return listOf()
    }

    fun List<Long>.i(ip: Int, rb: Int, p: Int) =
            when (val mode = when (p) {
                1 -> this[ip] % 1000 / 100
                2 -> this[ip] % 10000 / 1000
                3 -> this[ip] / 10000
                else -> error("Unknown param $p")
            }) {
                0L -> int(this[ip + p])
                1L -> ip + p
                2L -> rb + int(this[ip + p])
                else -> error("Unknown mode $mode")
            }

    operator fun List<Long>.get(ip: Int, rb: Int, p: Int) =
            getOrElse(i(ip, rb, p)) { 0 }

    operator fun MutableList<Long>.set(ip: Int, rb: Int, p: Int, v: Long) {
        val i = i(ip, rb, p)
        if (i < size) {
            set(i, v)
        } else {
            if (i > size) addAll(Array(i - size) { 0L })
            add(v)
        }
    }
}