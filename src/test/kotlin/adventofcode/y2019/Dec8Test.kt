package adventofcode.y2019

import org.junit.jupiter.api.Assertions
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

/**
 * TODO write documentation
 */
class Dec8Test : AbstractKotlinTest() {
    @Test
    fun one() {
        val text = readFile(1, Dec8().javaClass).trim()
        val input = text.map { (it - '0') }
        val chunks = input.chunked(25 * 6)
        val sorted = chunks.sortedBy { it.count { i -> i == 0 } }
        val list = sorted[0]
        Assertions.assertEquals(-1, list.count { it == 1 } * list.count { it == 2 })
    }

    @Test
    fun two() {
        val text = readFile(1, Dec8().javaClass).trim()
        val input = text.map { (it - '0').toInt() }
        val chunks = input.chunked(25 * 6)

        val image = mutableListOf<MutableList<Char>>()

        for (y in 0 until 6) {
            val line = mutableListOf<Char>()
            image.add(line)
            for (x in 0 until 25) {
                var p = ' '
                for (c in chunks) {
                    if (c[x + y * 25] == 0) {
                        p = ' '
                        break
                    } else if (c[x + y * 25] == 1){
                        p = 'X'
                        break
                    }
                }

                line.add(p)
            }
        }

        println(image.joinToString(separator = "\n") { it.joinToString(separator = "") })
    }

    @Test
    fun simple() {
        val input = "123456789012".map { (it - '0').toInt() }
        val chunks = input.chunked(3 * 2)
        val sorted = chunks.sortedBy { it.count { i -> i == 0 } }
        val list = sorted[0]
        list.count { it == 1 } * list.count { it == 2 }
    }
}