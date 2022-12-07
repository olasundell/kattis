package adventofcode.y2021

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec11Test : AbstractKotlinTest() {
    val s = """5483143223
2745854711
5264556173
6141336146
6357385478
4167524645
2176841721
6882881134
4846848554
5283751526"""

    @Test
    fun stepOnce() {
        val expected = """6594254334
3856965822
6375667284
7252447257
7468496589
5278635756
3287952832
7993992245
5957959665
6394862637"""
        val o = Dec11(1).readOctopii(Scanner(s))
        val result = o.iterate()
        assertEquals(expected, result.toString())
    }

    @Test
    fun stepTwice() {
        val expected = """8807476555
5089087054
8597889608
8485769600
8700908800
6600088989
6800005943
0000007456
9000000876
8700006848"""
        val o = Dec11(1).readOctopii(Scanner(s))
        val result = o.iterate()
        val result2 = result.iterate()
        assertEquals(expected, result2.toString())
    }

    @Test
    fun stepThrice() {
        val expected = """0050900866
8500800575
9900000039
9700000041
9935080063
7712300000
7911250009
2211130000
0421125000
0021119000"""
        val o = Dec11(1).readOctopii(Scanner(s))
        val result = o.iterate().iterate().iterate()
        assertEquals(expected, result.toString())
    }

    @Test
    fun simple() {
        val result = Dec11(10).solve(Scanner(s))

        assertEquals("204", result)

        val result2 = Dec11(100).solve(Scanner(s))

        assertEquals("1656", result2)
    }

    @Test
    fun secondSimple() {
        val result2 = Dec11(100).solve2(Scanner(s))

        assertEquals("195", result2)
    }

    val one = """4112256372
3143253712
4516848631
3783477137
3746723582
5861358884
4843351774
2316447621
6643817745
6366815868"""

    @Test
    fun one() {
        val result = Dec11(100).solve(Scanner(one))

        assertEquals("1603", result)
    }

    @Test
    fun two() {
        val result = Dec11(100).solve2(Scanner(one))

        assertEquals("", result)
    }
}