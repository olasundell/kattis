package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec23Test : AbstractKotlinTest() {
    @Test
    fun simple1() {
        Dec23(10).solve(Scanner("389125467"))
    }
}