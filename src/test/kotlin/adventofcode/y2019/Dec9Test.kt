package adventofcode.y2019

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * TODO write documentation
 */
class Dec9Test : AbstractKotlinTest() {
    @Test
    fun intMachine() {
        val mem = readFile(1, Dec9().javaClass).split(",").map{ it.trim().toLong() }
        IntMachine(mem, 2).intMachine()
        assertTrue(true)
    }

    @Test
    fun two() {
        val mem = readFile(1, Dec9().javaClass).split(",").map{ it.trim().toLong() }
        val dec5 = Dec5()
        runBlocking {
            val output = dec5.runProgram(mem, listOf(2))
            assertEquals("-1", output)
        }
    }

    @Test
    fun one() {
//        runTest(1, Dec9()::solve)
        val mem = readFile(1, Dec9().javaClass).split(",").map{ it.trim().toLong() }
//        IntMachine(mem, 1).intMachine()
        val dec5 = Dec5()
        runBlocking {
            val output = dec5.runProgram(mem, listOf(1))
            assertEquals("2714716640", output)
        }

//        val intMachineMem: List<Map<Long, Long>> = IntMachine(mem, 1).intMachine().map { it.mapIndexed { index, l -> index.toLong() to l }.toMap()}
//        val dec5Mem: MutableList<Map<Long, Long>> = dec5.memStates

//        for (i in intMachineMem.indices) {
//            assertEquals("iteration $i differs", intMachineMem[i], dec5Mem[i])
//            val intMap = intMachineMem[i]
//            val dec5Map = dec5Mem[i]

//            for (p in intMap.keys) {
//                val intm = intMap[p]
//                val dec5m = dec5Map.getOrDefault(p, 0)
//                assertEquals("iteration $i, key $p differs", intm, dec5m)
//            }
//        }
        
//        val channels = listOf(
//                Channel<Long>(Int.MAX_VALUE),
//                Channel(Int.MAX_VALUE)
//        )
//
//        channels[0].offer(1)
//
//        var actual = -1L
//
//        val actualiser = GlobalScope.launch {
//            while (true) {
//                actual = channels[1].receive()
//                println("rec $actual")
//                channels[0].send(actual)
//            }
//        }
//
//
//        runBlocking {
//            var state = Dec5.State("0", mem, Dec5.Ip(0, 0), channels[0], channels[1], true)
//
//            while (state.running) {
//                state = state.execute()
//            }
//        }
//
//        actualiser.cancel()
//
//        assertEquals(-2, actual)
    }

    @Test
    fun simple() {
        val mem = listOf(109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99)
        val expected = "109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99"
        runBlocking {
            val output = Dec5().runProgram(mem.map{it.toLong()}, listOf())
            assertEquals(expected, output)
        }
    }

    @Test
    fun `16 bit number`() {
        val mem = listOf(1102,34915192,34915192,7,4,7,99,0)

        runBlocking {
            val output = Dec5().runProgram(mem.map{it.toLong()}, listOf()).toLong()
            assertEquals(1219070632396864, output)
        }
    }

    @Test
    fun largeNumber() {
        val mem = listOf<Long>(104,1125899906842624,99)

        runBlocking {
            val output = Dec5().runProgram(mem, listOf())
            assertEquals(1125899906842624, output.toLong())
        }
    }
}