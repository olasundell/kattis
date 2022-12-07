package adventofcode.y2020

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec10Test : AbstractKotlinTest() {
    val harderInput = """28
33
18
42
31
14
46
20
48
47
24
23
49
45
19
38
39
11
1
32
25
35
8
17
7
9
4
2
34
10
3""".trimIndent()

    val simpleInput = """16
10
15
5
1
11
7
19
6
12
4""".trimIndent()

    @Test
    fun simple1() {
        val result = Dec10().solve(Scanner(simpleInput))

        assertEquals("${7 * 5}", result)
    }

    @Test
    fun notSoSimple1() {
        val result = Dec10().solve(Scanner(harderInput))

        assertEquals("${22 * 10}", result)
    }

    @Test
    fun one() {
        runTest(1, Dec10()::solve)
    }

    @Test
    fun simple2() {
        val result = Dec10().solve2(Scanner(simpleInput))

        assertEquals("8", result)
    }

    @Test
    fun notSoSimple2() {
        val result = Dec10().solve2(Scanner(harderInput))

        assertEquals("19208", result)
    }

    @Test
    fun two() {
        runTest(1, Dec10()::solve2)
    }
}