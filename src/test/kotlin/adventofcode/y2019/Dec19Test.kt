package adventofcode.y2019

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.exitProcess
import kotlin.test.assertEquals

/**
 * TODO write documentation
 */
class Dec19Test : AbstractKotlinTest() {
    val memory = "109,424,203,1,21102,11,1,0,1105,1,282,21101,18,0,0,1106,0,259,1202,1,1,221,203,1,21101,0,31,0,1106,0,282,21102,38,1,0,1105,1,259,20101,0,23,2,22102,1,1,3,21102,1,1,1,21102,57,1,0,1105,1,303,2101,0,1,222,21002,221,1,3,20101,0,221,2,21102,1,259,1,21101,0,80,0,1105,1,225,21102,40,1,2,21101,0,91,0,1105,1,303,1201,1,0,223,20101,0,222,4,21101,0,259,3,21101,0,225,2,21101,0,225,1,21102,118,1,0,1105,1,225,21001,222,0,3,21102,1,144,2,21101,0,133,0,1105,1,303,21202,1,-1,1,22001,223,1,1,21102,148,1,0,1105,1,259,1202,1,1,223,20101,0,221,4,21001,222,0,3,21102,1,14,2,1001,132,-2,224,1002,224,2,224,1001,224,3,224,1002,132,-1,132,1,224,132,224,21001,224,1,1,21102,195,1,0,106,0,109,20207,1,223,2,20101,0,23,1,21101,0,-1,3,21102,214,1,0,1105,1,303,22101,1,1,1,204,1,99,0,0,0,0,109,5,2101,0,-4,249,22101,0,-3,1,21201,-2,0,2,22101,0,-1,3,21101,0,250,0,1105,1,225,21202,1,1,-4,109,-5,2105,1,0,109,3,22107,0,-2,-1,21202,-1,2,-1,21201,-1,-1,-1,22202,-1,-2,-2,109,-3,2106,0,0,109,3,21207,-2,0,-1,1206,-1,294,104,0,99,21202,-2,1,-2,109,-3,2106,0,0,109,5,22207,-3,-4,-1,1206,-1,346,22201,-4,-3,-4,21202,-3,-1,-1,22201,-4,-1,2,21202,2,-1,-1,22201,-4,-1,1,21202,-2,1,3,21101,343,0,0,1106,0,303,1105,1,415,22207,-2,-3,-1,1206,-1,387,22201,-3,-2,-3,21202,-2,-1,-1,22201,-3,-1,3,21202,3,-1,-1,22201,-3,-1,2,21202,-4,1,1,21102,384,1,0,1106,0,303,1105,1,415,21202,-4,-1,-4,22201,-4,-3,-4,22202,-3,-2,-2,22202,-2,-4,-4,22202,-3,-2,-3,21202,-4,-1,-2,22201,-3,-2,1,22101,0,1,-4,109,-5,2106,0,0"

    companion object {
        val maxX = 100_000
        val maxY = 100_000
        val input = Channel<Long>(Int.MAX_VALUE)
        val output = Channel<Long>(Int.MAX_VALUE)
    }

    @Test
    fun one() {
        val total = AtomicInteger(0)

//        val jobs = mutableSetOf<Job>()
        val set = mutableSetOf<P>()
        var startOn = 400
        runBlocking {
            for (y in 286 until maxY) {
                startOn = iterate(startOn, y, set, total)
            }
        }

//        runBlocking {
//            jobs.forEach { it.join() }
//        }

//        printBeam(set)
        assertEquals(0, total.get())
    }

    private fun printBeam(set: MutableSet<P>) {
        for (y in 0 until 50) {
            for (x in 0 until maxX) {
                if (set.contains(P(x, y, true))) {
                    print("X")
                } else if (set.contains(P(x, y, false))) {
                    print(",")
                } else {
                    print(".")
                }
            }

            println("")
        }
    }

    data class P(val x: Int, val y: Int, val tracted: Boolean)

    private suspend fun iterate(startOn: Int, y: Int, set: MutableSet<P>, total: AtomicInteger): Int {
        for (x in startOn until maxX) {
            if (execOnce(x, y) == 1L) {
                if (execOnce(x + 99, y) == 1L) {
                    println("wide enough at $x $y")
                    if (execOnce(x + 99, y - 99) == 1L) {
                        println("${x * 10_000 + (y - 99)}")
                        exitProcess(0)
                    }
                }
                return x
            }
        }
//                set.add(P(x, y, true))
//                if (!on) {
//                    newOn = x
//                }
//                on = true
//                total.incrementAndGet()
//            } else {
//                set.add(P(x, y, false))
//                if (on) {
//                    return newOn
//                }
//            }
//        }
        return startOn
    }

    private suspend fun execOnce(x: Int, y: Int): Long {
        input.send(x.toLong())
        input.send(y.toLong())
        Dec5().runProgramOutputOnChannel(memory.split(",").map { it.toLong() }, output = output, input = input)
        return output.receive()
    }
}