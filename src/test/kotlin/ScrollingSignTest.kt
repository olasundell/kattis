import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class ScrollingSignTest : AbstractKotlinTest() {
    private val sign = ScrollingSign()

    @Test
    fun one() {
        runTest(1, sign::solve)
    }

    @Test
    fun two() {
        runTest(2, sign::solve)
    }

    @Test
    fun three() {
        runTest(3, sign::solve)
    }

    @Test
    fun four() {
        runTest(4, sign::solve)
    }

    @Test
    fun five() {
        runTest(5, sign::solve)
    }

    @Test
    fun six() {
        runTest(6, sign::solve)
    }

    @Test
    fun eight() {
        runTest(8, sign::solve)
    }

    @Test
    fun test16BitChecksum() {
        val one = sign.reversedBitChecksum("LADLASFOOBARXYZZY", 0)
        val two = sign.bitChecksum("XYZZYATROSYSINTHE")

        val pos = sign.match(one, two)
        Assert.assertEquals(4, pos)
    }

    @Test
    fun testConcat() {
        val one = "LADLASFOOBARXYZZY"
        val two ="XYZZYATROSYSINTHE"

        val concatted = sign.concat(one, two, 4)
        Assert.assertEquals("LADLASFOOBARXYZZYATROSYSINTHE", concatted)
    }

    @Test
    fun testUniqueChecksum() {
        val one = "OSR"
        val two = "GMT"

        val revChecksum = sign.reversedBitChecksum(one)
        val checksum = sign.bitChecksum(two)

        val result = sign.reduceStrings(one, two)
        Assert.assertEquals(result, "$one$two")
    }
}
