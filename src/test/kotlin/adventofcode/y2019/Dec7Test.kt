package adventofcode.y2019

import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.debug.DebugProbes
import kotlinx.coroutines.debug.junit4.CoroutinesTimeout
import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec7Test : AbstractKotlinTest() {
//    @Rule
//    @JvmField
//    val timeout = CoroutinesTimeout.seconds(5)

    @Test
    fun one() {
        runTest(1, Dec7()::solve)
    }

    @Test
    fun three() {
        runTest(3, Dec7()::solve)
    }

    @Test
    fun four() {
        runTest(4, Dec7()::solve)
    }

    @Test
    fun five() {
        runTest(5, Dec7()::solve)
    }

    @Test
    fun easy() {
        val mem = listOf(3,15,3,16,1002,16,10,16,1,16,15,15,4,15,99,0,0,4)
//        4,3,2,1,0
        val params = listOf(4, 3, 2, 1,0 )
        val last = run(mem, params)

        assertEquals(43210, last)
    }

    @Test
    fun slightlyHarder() {
        val mem = listOf(3,23,3,24,1002,24,10,24,1002,23,-1,23,101,5,23,23,1,24,23,23,4,23,99,0,0)
        val params = listOf(0,1,2,3,4)

        val result = run(mem, params)
        assertEquals(54321, result)
    }

    @Test
    fun evenHarder() {
        val mem = listOf(3,31,3,32,1002,32,10,32,1001,31,-2,31,1007,31,0,33,1002,33,7,33,1,33,31,31,1,32,31,31,4,31,99,0,0,0)
        val params = listOf( 1,0,4,3,2)
        val result = run(mem, params)

        assertEquals(65210, result)
    }

    @Test
    fun `harder feedback`() {
        val expected = 18216
        val params = listOf(9,7,8,5,6)
        val mem = listOf(3,52,1001,52,-5,52,3,53,1,52,56,54,1007,54,5,55,1005,55,26,1001,54,
                -5,54,1105,1,12,1,53,54,53,1008,54,0,55,1001,55,1,55,2,53,55,53,4,
                53,1001,56,-1,56,1005,56,6,99,0,0,0,0,10)
        assertEquals(expected, runFeedbacked(mem, params))
    }

    @ExperimentalCoroutinesApi
    @Test
    fun easyFeedback() {
        DebugProbes.install()
        val expected = 139629729
        val params = listOf(9, 8, 7, 6, 5)
        val mem = listOf(3, 26, 1001, 26, -4, 26, 3, 27, 1002, 27, 2, 27, 1, 27, 26, 27, 4, 27, 1001, 28, -1, 28, 1005, 28, 6, 99, 0, 0, 5)

        assertEquals(expected, runFeedbacked(mem, params))
    }

    @Test
    fun two() {
        val mem = readFile(2, Dec7().javaClass).split(",").map{ it.trim().toInt() }
        val params = listOf(9, 8, 7, 6, 5)
        val permutations = Dec7().permute(params)
        val results = mutableListOf<Long>()

        permutations.map {
            results.add(runFeedbacked(mem, it))
        }

        assertEquals(0, results.max())
    }

    private fun runFeedbacked(mem: List<Int>, params: List<Int>): Long {
        return runFeedbackedLong(mem.map {it.toLong()}, params.map { it.toLong() })
    }

    private fun runFeedbackedLong(mem: List<Long>, params: List<Long>): Long {
        val channels = listOf(
                Channel<Long>(Int.MAX_VALUE),
                Channel(Int.MAX_VALUE),
                Channel(Int.MAX_VALUE),
                Channel(Int.MAX_VALUE),
                Channel(Int.MAX_VALUE),
                Channel(Int.MAX_VALUE)
        )

        for (i in 0..4) {
            channels[i].offer(params[i])
        }

        var actual = -1L

        val actualiser = GlobalScope.launch {
            while (true) {
                actual = channels[5].receive()
                channels[0].send(actual)
            }
        }

        val amps = mutableListOf<Dec5.State>(
            Dec5.State("0", mem, Dec5.Ip(0, 0), channels[0], channels[1], true),
            Dec5.State("1", mem, Dec5.Ip(0, 0), channels[1], channels[2], true),
            Dec5.State("2", mem, Dec5.Ip(0, 0), channels[2], channels[3], true),
            Dec5.State("3", mem, Dec5.Ip(0, 0), channels[3], channels[4], true),
            Dec5.State("4", mem, Dec5.Ip(0, 0), channels[4], channels[5], true)
        )


        val jobs = amps.map {
            GlobalScope.launch {
                var state = it
                while (state.running) {
                    state = state.execute()
                }
            }
        }

        runBlocking {
            channels[0].offer(0)
            jobs[4].join()
        }

        actualiser.cancel()

        return actual
    }

    private fun run(mem: List<Int>, params: List<Int>): Int {
        var last = 0

        runBlocking {
            val list = mutableListOf<Int>(0)
            for (i in 0..4) {
                last = Dec5().runProgram(mem.map{it.toLong()}.toList(), listOf(params[i], last)).toInt()
                list.add(last)
            }
        }
        return last
    }
}