import kattis.RunLengthEncodingRun
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class RunLengthEncodingRunTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, RunLengthEncodingRun()::solve)
    }

    @Test
    fun two() {
        runTest(2, RunLengthEncodingRun()::solve)
    }
}