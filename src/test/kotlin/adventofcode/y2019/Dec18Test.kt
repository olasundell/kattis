package adventofcode.y2019

import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class Dec18Test : AbstractKotlinTest() {
    @Test
    fun real() {
        runTest(1, Dec18()::solve)
    }
    @Test
    fun easy() {
        runTest(2, Dec18()::solve)
    }
    @Test
    fun `slightly harder`() {
        runTest(3, Dec18()::solve)
    }
    @Test
    fun `slightly more harder`() {
        runTest(4, Dec18()::solve)
    }
    @Test
    fun `even harder`() {
        runTest(5, Dec18()::solve)
    }
    @Test
    fun `really hard`() {
        runTest(6, Dec18()::solve)
    }
}