package adventofcode.y2020

import util.AbstractKotlinTest

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

/**
 * TODO write documentation
 */
internal class Dec22Test : AbstractKotlinTest() {
    val simple = """Player 1:
9
2
6
3
1

Player 2:
5
8
4
7
10"""

    val real = """Player 1:
2
31
14
45
33
18
29
36
44
47
38
6
9
5
48
17
50
41
4
21
42
23
25
28
3

Player 2:
26
16
27
12
49
32
19
46
37
15
10
30
11
24
1
40
7
8
43
34
20
35
22
39
13"""

    @Test
    fun simple1() {
        val actual = Dec22().solve(Scanner(simple))
        assertEquals("306", actual)
    }

    @Test
    fun one() {
        val actual = Dec22().solve(Scanner(real))
        assertEquals("1", actual)
    }

    @Test
    fun simple2() {
        val actual = Dec22().solve2(Scanner(simple))
        assertEquals("291", actual)
    }

    @Test
    fun two() {
        val actual = Dec22().solve2(Scanner(real))
        assertEquals("1", actual)
    }
}