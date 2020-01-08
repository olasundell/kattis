package adventofcode.y2019;

import adventofcode.y2018.Dec13.*
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.Channel
import java.lang.System.err
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean

/**
 * TODO write documentation
 */
class Dec11(private val startColour: Long) {
    val blocks = mutableMapOf<Point, Boolean>()

    fun solve(scanner: Scanner): String {
        val memory = scanner.nextLine().split(",").map { it.toLong() }

        val output = Channel<Long>(capacity = Int.MAX_VALUE)
        val input = Channel<Long>(capacity = Int.MAX_VALUE)

        var posDir = CartPosDir(Point(0, 0), Direction.UP)

        var str = ""
        input.offer(startColour)

        val running = AtomicBoolean(true)
        val paintedOnce = mutableSetOf<Point>()

        GlobalScope.launch (Dispatchers.IO) {
            while (running.get()) {
                val colour = output.receive()
                val turn = output.receive()
//                blocks.compute(posDir.pos) { t: Point, u: Boolean? -> u?.or(colour == 1L) ?: (colour == 1L) }
//                if (blocks[posDir.pos] != null && blocks[posDir.pos])

                blocks[posDir.pos] = (colour == 1L)
                if (colour == 1L) {
                    paintedOnce.add(posDir.pos)
                }

                val direction = if (turn == 0L) {
                    posDir.dir.left()
                } else {
                    posDir.dir.right()
                }

                posDir = CartPosDir(posDir.pos + Point(direction.x, direction.y), direction)

                val element = if (blocks.getOrDefault(posDir.pos, false)) {
                    1L
                } else {
                    0L
                }

//                err.println("$colour $turn $posDir send $element")

                input.send(element)
            }
        }

        runBlocking {
            str = Dec5().runProgram(
                    memory = memory,
                    output = output,
                    input = input
            )
        }

        running.set(false)

//        return "${blocks.values.filter { it == true }.count()}"
        return "${paintedOnce.size}"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec11(-1L).solve(scanner))
}