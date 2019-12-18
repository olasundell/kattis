package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test
import java.awt.Point
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

}