import kattis.LastFactorialDigit
import util.AbstractKotlinTest

import org.junit.Test

class LastFactorialDigitTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, LastFactorialDigit()::solve)
    }

    @Test
    fun two() {
        runTest(2, LastFactorialDigit()::solve)
    }
}