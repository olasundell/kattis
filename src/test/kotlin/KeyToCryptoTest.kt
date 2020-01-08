import kattis.KeyToCrypto
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class KeyToCryptoTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, KeyToCrypto()::solve)
    }

    @Test
    fun two() {
        runTest(2, KeyToCrypto()::solve)
    }

    @Test
    fun three() {
        runTest(3, KeyToCrypto()::solve)
    }
}