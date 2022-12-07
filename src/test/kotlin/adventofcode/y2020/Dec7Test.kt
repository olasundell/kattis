package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec7Test : AbstractKotlinTest() {
    val simpleInput1 = """light red bags contain 1 bright white bag, 2 muted yellow bags.
dark orange bags contain 3 bright white bags, 4 muted yellow bags.
bright white bags contain 1 shiny gold bag.
muted yellow bags contain 2 shiny gold bags, 9 faded blue bags.
shiny gold bags contain 1 dark olive bag, 2 vibrant plum bags.
dark olive bags contain 3 faded blue bags, 4 dotted black bags.
vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.
faded blue bags contain no other bags.
dotted black bags contain no other bags."""

    val simpleInput2 = """shiny gold bags contain 2 dark red bags.
dark red bags contain 2 dark orange bags.
dark orange bags contain 2 dark yellow bags.
dark yellow bags contain 2 dark green bags.
dark green bags contain 2 dark blue bags.
dark blue bags contain 2 dark violet bags.
dark violet bags contain no other bags.""".trimIndent()

    @Test
    fun simple() {
        val result = Dec7().solve(Scanner(simpleInput1))

        assertEquals("4", result)
    }

    @Test
    fun countBags() {
        val result = Dec7().countUpwards(mapOf("foo" to listOf("bar")), "foo")

        assertEquals(1, result.size)
    }

    @Test
    fun one() {
        runTest(1, Dec7()::solve)
    }

    @Test
    fun simple2() {
        val result = Dec7().solve2(Scanner(simpleInput1))

        assertEquals("32", result)
    }

    @Test
    fun slightlyLessSimple2() {
        val result = Dec7().solve2(Scanner(simpleInput2))

        assertEquals("126", result)
    }

    @Test
    fun two() {
        runTest(1, Dec7()::solve2)
    }
}