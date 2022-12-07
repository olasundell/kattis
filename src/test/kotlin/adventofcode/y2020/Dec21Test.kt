package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec21Test : AbstractKotlinTest() {
    val input1 = """mxmxvkd kfcds sqjhc nhms (contains dairy, fish)
trh fvjkl sbzzf mxmxvkd (contains dairy)
sqjhc fvjkl (contains soy)
sqjhc mxmxvkd sbzzf (contains fish)"""

    @Test
    fun simple1() {
        val actual = Dec21().solve(Scanner(input1))
        assertEquals("5", actual)
    }
}