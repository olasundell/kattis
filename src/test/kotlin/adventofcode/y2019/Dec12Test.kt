package adventofcode.y2019

import adventofcode.y2019.Dec12.*
import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec12Test : AbstractKotlinTest() {
    @Test
    fun `coords should be properly created from strings`() {
        val result = Dec12().coordFromStr("<x=2, y=-6, z=1>")
        assertNotNull(result)
        assertEquals(2, result.x)
        assertEquals(-6,  result.y)
        assertEquals(1, result.z)

        val result2 = Dec12().coordFromStr("<x= 2, y= -6, z= 1>")

        assertNotNull(result2)
        assertEquals(2, result2.x)
        assertEquals(-6,  result2.y)
        assertEquals(1, result2.z)
    }

    @Test
    fun `moons should have correct velocity`() {
        val dec12 = Dec12()
        val first = Moon(Tri(1, 1, 1))
        val second = Moon(Tri(4, 4, 4))
        val result = dec12.calcRelativeVelocities(first, second)

        assertEquals(first.withVel(Tri(1, 1, 1)), result.first)
        assertEquals(second.withVel(Tri(-1, -1, -1)), result.second)
    }

    @Test
    fun `simple iterations`() {
        val start = """<x=-1, y=0, z=2>
            <x=2, y=-10, z=-7>
            <x=4, y=-8, z=8>
            <x=3, y=5, z=-1>""".trimIndent().split("\n").map { it.trim() }.filterNot { it.isBlank() }

        val dec12 = Dec12()

        val result = dec12.iterate(dec12.createMoons(start), 1)

        assertNotNull(result)
    }

    @Test
    fun `several iterations`() {
        val start = """<x=-8, y=-10, z=0>
            <x=5, y=5, z=10>
            <x=2, y=-7, z=3>
            <x=9, y=-8, z=-3>""".trimIndent().split("\n").map { it.trim() }.filterNot { it.isBlank() }

        val dec12 = Dec12()

        val result = dec12.iterate(dec12.createMoons(start), 10)

        val ten = """pos=<x= -9, y=-10, z=  1>, vel=<x= -2, y= -2, z= -1>
    pos=<x=  4, y= 10, z=  9>, vel=<x= -3, y=  7, z= -2>
    pos=<x=  8, y=-10, z= -3>, vel=<x=  5, y= -1, z= -2>
    pos=<x=  5, y=-10, z=  3>, vel=<x=  0, y= -4, z=  5>""".split(("\n")).map { it.trim() }

        val tenMoons = dec12.createMoonsWithVelocity(ten)
        assertEquals(tenMoons, result)
    }

    @Test
    fun one() {
        runTest(1, Dec12()::solve)
    }
}