package adventofcode.y2019

import org.junit.jupiter.api.Assertions.*
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class Dec4Test : AbstractKotlinTest() {
    private val dec4 = Dec4()

    @Test
    fun one() {
        runTest(1, dec4::solve)
    }

    @Test
    fun two() {
        runTest(2, dec4::solve)
    }

    @Test
    fun threeEqualityShouldWork() {
        assertEquals(2, dec4.findStrictThreeInARow("123334"))
        assertEquals(-1, dec4.findStrictThreeInARow("123333"))

        assertEquals(0, dec4.findStrictThreeInARow("333456"))
        assertEquals(-1, dec4.findStrictThreeInARow("333345"))

        assertEquals(3, dec4.findStrictThreeInARow("123444"))
        assertEquals(-1, dec4.findStrictThreeInARow("124444"))
    }

    @Test
    fun threeButNotTwo() {
        assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("555678"))
        assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("155567"))
        assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("125556"))
        assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("123555"))
    }

    @Test
    fun strictThreeTwoTimes() {
        assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("444555"))
    }

    @Test
    fun threeAndTwoButNoDoubleThree() {
        assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("555668"))
        assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("555677"))
        assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("155566"))
        assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("225556"))
        assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("223555"))
        assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("233555"))
    }

    @Test
    fun sixInARow() {
        assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("111111"))
    }

    @Test
    fun oneTwoThreeDouble() {
        assertFalse(dec4.hasThreeOrMoreInARowAndNoTwo("112233"))
    }

    @Test
    fun fiveInARow() {
        assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("122222"))
        assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("222223"))
    }

    @Test
    fun fourInARow() {
        assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("123333"))
        assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("222234"))
        assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("122223"))

        assertFalse(dec4.hasThreeOrMoreInARowAndNoTwo("112222"))
        assertFalse(dec4.hasThreeOrMoreInARowAndNoTwo("222233"))
    }

    @Test
    fun shouldFind() {
        val r4  = """(\d)\1{4}""".toRegex()
        val r56 = """(\d)\1{5,6}""".toRegex()
        val find = r4.find("111123")

        assertNotNull(find)
    }
}