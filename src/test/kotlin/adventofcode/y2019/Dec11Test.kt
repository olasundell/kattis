package adventofcode.y2019

import adventofcode.y2018.Dec13
import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec11Test : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Dec11(0L)::solve)
    }

    @Test
    fun two() {
        val dec11 = Dec11(1L)
        runTest(2, dec11::solve)
        val arr = mutableListOf<String>()
        val maxX = dec11.blocks.keys.maxBy { it.x }!!.x
        val maxY = dec11.blocks.keys.maxBy(Dec13.Point::y)!!.y

        for (y in 0..maxY) {
            var str = ""
            for (x in 0..maxX) {
                str += if (dec11.blocks.getOrDefault(Dec13.Point(x, y), false)) {
                    "x"
                } else {
                    " "
                }
            }
            arr.add(str)
        }

        println(arr.joinToString(separator = "\n"))

        assertTrue(false)
    }
}