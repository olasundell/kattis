package adventofcode.y2019

import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Test

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
        Assert.assertEquals(2, dec4.findStrictThreeInARow("123334"))
        Assert.assertEquals(-1, dec4.findStrictThreeInARow("123333"))

        Assert.assertEquals(0, dec4.findStrictThreeInARow("333456"))
        Assert.assertEquals(-1, dec4.findStrictThreeInARow("333345"))

        Assert.assertEquals(3, dec4.findStrictThreeInARow("123444"))
        Assert.assertEquals(-1, dec4.findStrictThreeInARow("124444"))
    }

    @Test
    fun threeButNotTwo() {
        Assert.assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("555678"))
        Assert.assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("155567"))
        Assert.assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("125556"))
        Assert.assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("123555"))
    }

    @Test
    fun strictThreeTwoTimes() {
        Assert.assertTrue(dec4.hasThreeInARowButNotTwoInRemainder("444555"))
    }

    @Test
    fun threeAndTwoButNoDoubleThree() {
        Assert.assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("555668"))
        Assert.assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("555677"))
        Assert.assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("155566"))
        Assert.assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("225556"))
        Assert.assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("223555"))
        Assert.assertFalse(dec4.hasThreeInARowButNotTwoInRemainder("233555"))
    }

    @Test
    fun sixInARow() {
        Assert.assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("111111"))
    }

    @Test
    fun oneTwoThreeDouble() {
        Assert.assertFalse(dec4.hasThreeOrMoreInARowAndNoTwo("112233"))
    }

    @Test
    fun fiveInARow() {
        Assert.assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("122222"))
        Assert.assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("222223"))
    }

    @Test
    fun fourInARow() {
        Assert.assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("123333"))
        Assert.assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("222234"))
        Assert.assertTrue(dec4.hasThreeOrMoreInARowAndNoTwo("122223"))

        Assert.assertFalse(dec4.hasThreeOrMoreInARowAndNoTwo("112222"))
        Assert.assertFalse(dec4.hasThreeOrMoreInARowAndNoTwo("222233"))
    }

    @Test
    fun shouldFind() {
        val r4  = """(\d)\1{4}""".toRegex()
        val r56 = """(\d)\1{5,6}""".toRegex()
        val find = r4.find("111123")

        Assert.assertNotNull(find)
    }
}