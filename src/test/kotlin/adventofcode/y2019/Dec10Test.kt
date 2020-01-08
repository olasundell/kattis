package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.awt.Point
import java.awt.geom.Point2D.distance
import java.lang.System.err
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * TODO write documentation
 */
class Dec10Test : AbstractKotlinTest() {
    @Test
    fun one() {
        val dec10 = Dec10()
        runTest(1, dec10::solve)

        dec10.revKMap
    }

    @Test
    fun second() {
        val dec10 = Dec10()
        runTest(1, dec10::solve)

//        dec10.revKMap
        val result = vaporise(dec10)
        assertEquals(Point(-1, -1), result[199])
    }

    private fun vaporise(dec10: Dec10): List<Point> {
        val map: MutableMap<Dec10.Direction, MutableSet<Point>> = dec10.revKMap[dec10.point]!!
        assertNotNull(map)
        val keys = map.keys.sorted().toMutableList()

        var i = 0
        val vapored = mutableListOf<Point>()
        repeat(400) {
            val k = keys[i]
            val p = map[k]!!.minBy { dec10.point.distance(it) }!!
            err.println("${it + 1} ${p.x},${p.y}")
            vapored.add(p)
            map[k]!!.remove(p)
            if (map[k].isNullOrEmpty()) {
                map.remove(k)
                keys.remove(k)
                if (i == keys.size) {
                    i = 0
                }
            } else {
                i = (i + 1) % keys.size
            }
            if (keys.isEmpty()) {
                return vapored
//                fail("Keys are prematurely empty")
            }
        }
//        while (keys.isNotEmpty())

        return vapored
    }

    @Test
    fun two() {
        runTest(2, Dec10()::solve)
    }

    @Test
    fun three() {
        runTest(3, Dec10()::solve)
    }

    @Test
    fun four() {
        runTest(4, Dec10()::solve)
    }

    @Test
    fun five() {
        runTest(5, Dec10()::solve)
    }

    @Test
    fun sixVaporise() {
        val dec10 = Dec10()
        runTest(6, dec10::solve)

        val result: List<Point> = vaporise(dec10)
        assertEquals(Point(11,12), result[0], "0")
        assertEquals(Point(12, 1), result[1], "1")
        assertEquals(Point(12, 2), result[2], "2")
        assertEquals(Point(12, 8), result[9], "9")
//        The 20th asteroid to be vaporized is at 16,0.
        assertEquals(Point(16, 0), result[19], "19")
//        The 50th asteroid to be vaporized is at 16,9.
        assertEquals(Point(16, 9), result[49], "49")
//        The 100th asteroid to be vaporized is at 10,16.
        assertEquals(Point(10, 16), result[99], "99")
//        The 199th asteroid to be vaporized is at 9,6.
        assertEquals(Point(9, 6), result[198], "198")
//        The 200th asteroid to be vaporized is at 8,2.
        assertEquals(Point(8, 2), result[199], "199")
//        The 201st asteroid to be vaporized is at 10,9.
        assertEquals(Point(10, 9), result[200], "200")
//        The 299th and final asteroid to be vaporized is at 11,1.
        assertEquals(Point(11, 1), result[298], "298")
    }
}