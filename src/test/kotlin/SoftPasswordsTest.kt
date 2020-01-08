import kattis.SoftPasswords
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class SoftPasswordsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, SoftPasswords()::solve)
    }

    @Test
    fun two() {
        runTest(2, SoftPasswords()::solve)
    }

    @Test
    fun three() {
        runTest(3, SoftPasswords()::solve)
    }

    @Test
    fun four() {
        runTest(4, SoftPasswords()::solve)
    }

    @Test
    fun five() {
        runTest(5, SoftPasswords()::solve)
    }

    @Test
    fun six() {
        runTest(6, SoftPasswords()::solve)
    }
}