import kattis.Playfair
import org.junit.jupiter.api.Assertions
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class PlayfairTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Playfair()::solve)
    }

    @Test
    fun two() {
        runTest(2, Playfair()::solve)
    }

    @Test
    fun encryptTwoShouldEncryptProperly() {
        val matrix = Playfair.Matrix()
        val str = "PLAYFIREXMBCDGHJKNOSTUVWZ"
        str.forEachIndexed { index, c -> matrix.put(c, index) }

        val pf = Playfair()

        val result = pf.encryptTwo('C', 'H', matrix)
        Assertions.assertEquals("DB", result)

        val result2 = pf.encryptTwo('V', 'A', matrix)
        Assertions.assertEquals("AE", result2)

        val result3 = pf.encryptTwo('K', 'M', matrix)
        Assertions.assertEquals("SR", result3)
    }
}
