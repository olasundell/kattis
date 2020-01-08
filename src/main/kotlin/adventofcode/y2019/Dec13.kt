package adventofcode.y2019

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.time.Instant
import java.util.*

/**
 * TODO write documentation
 */
class Dec13 {
    fun solveSecond(scanner: Scanner): String {
        val memory = scanner.nextLine().split(",").map { it.toLong() }
        val output = Channel<Long>()
        val input = Channel<Long>()
        var running = true

        val tiles = mutableMapOf<Pair<Long, Long>, Long>()
        var currentScore = 0L
        var ts = Instant.now()

        var ballPos: Pair<Long, Long> = Pair(-1, -1)
        var paddlePos = Pair(-1L, -1L)
        GlobalScope.launch(Dispatchers.IO) {
            while (running) {
                val x = output.receive()
                val y = output.receive()
                val t = output.receive()

                if (x == -1L && y == 0L) {
                    currentScore = t
                    println("current score is $currentScore remaining blocks is ${tiles.values.count { it == 2L }}")
//                    printTiles(tiles)
//                    input.send(0L)
                } else {
//                    println("Adding $x $y as $t")
                    tiles[Pair(x, y)] = t

                    if (t == 3L) {
                        paddlePos = Pair(x, y)
                    } else if (t == 4L) {
                        ballPos = Pair(x, y)
                    }
//                        printTiles(tiles)
//                        input.send(0L)
//                    }
                }
                ts = Instant.now()
            }
        }

        GlobalScope.launch(Dispatchers.IO) {
            while (running) {
                val now = Instant.now()
                if (now.toEpochMilli() - ts.toEpochMilli() > 100) {
//                    printTiles(tiles)
                    input.send(
                            if (paddlePos.first > ballPos.first) {
                                -1L
                            } else if (paddlePos.first < ballPos.first) {
                                1L
                            } else {
                                0L
                            }
                    )
                }
                Thread.sleep(5)
            }
        }

        runBlocking {
            Dec5().runProgram(memory, output, input)
        }

        running = false

        return "${tiles.size}"
    }

    fun printTiles(tiles: Map<Pair<Long, Long>, Long>) {
        val maxX = tiles.keys.map { it.first }.max() ?: 0
        val maxY = tiles.keys.map { it.second }.max() ?: 0

        val lines = mutableListOf<String>()
        for (y in 0..maxY) {
            val line = mutableListOf<Char>()
            for (x in 0..maxX) {
                line.add(when (tiles[Pair(x, y)]) {
                    0L -> ' '
                    1L -> '#'
                    2L -> 'X'
                    3L -> '='
                    4L -> 'o'
                    else -> ' '
                })
            }
            lines.add(line.joinToString(separator = ""))
        }
        println(lines.joinToString(separator = "\n"))
        println(" ------------------------------------ ")
    }

    fun solveFirst(scanner: Scanner): String {
        val memory = scanner.nextLine().split(",").map { it.toLong() }
        val output = Channel<Long>()
        var running = true

        val tiles = mutableSetOf<Pair<Long, Long>>()

        GlobalScope.launch {
            while (running) {
                val x = output.receive()
                val y = output.receive()
                val t = output.receive()

                if (t == 2L) {
                    println("Adding $x $y")
                    tiles.add(Pair(x, y))
                }
            }
        }

        runBlocking {
            Dec5().runProgram(memory, output, Channel())
        }

        Thread.sleep(500)

        running = false

        return "${tiles.size}"
    }
}

//fun main(args: Array<String>) {
//    val scanner = Scanner(System.`in`)
//    System.out.println(Dec13().solve(scanner))
//}