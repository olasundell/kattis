import kattis.DelimiterSoup
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class DelimiterSoupTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, DelimiterSoup()::solve)
    }

    @Test
    fun two() {
        runTest(2, DelimiterSoup()::solve)
    }

    @Test
    fun three() {
        runTest(3, DelimiterSoup()::solve)
    }

    @Test
    fun four() {
        runTest(4, DelimiterSoup()::solve)
    }

    @Test
    fun five() {
        runTest(5, DelimiterSoup()::solve)
    }

}
