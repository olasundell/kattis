package adventofcode.y2019

import util.AbstractKotlinTest

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.assertEquals

/**
 * TODO write documentation
 */
class Dec16Test : AbstractKotlinTest() {
    private val dec16= Dec16()
/*

    @Test
    fun patternAt() {
        assertEquals(1, dec16.patternAt(0, 0))
        assertEquals(0, dec16.patternAt(0, 1))
        assertEquals(-1, dec16.patternAt(0, 2))
        assertEquals(0, dec16.patternAt(0, 5))
        assertEquals(-1, dec16.patternAt(0, 6))

        assertEquals(0, dec16.patternAt(1, 0))
        assertEquals(1, dec16.patternAt(1, 2))
        assertEquals(1, dec16.patternAt(1, 3))
        assertEquals(0, dec16.patternAt(1, 4))

        assertEquals(1, dec16.patternAt(3, 6))
        assertEquals(0, dec16.patternAt(3, 7))
    }

    @ParameterizedTest
    @MethodSource("patternParams")
//    fun paramPatternAt(expected: Int, eight: Int, index: Int) {
    fun paramPatternAt(param: Param) {
        assertEquals(param.expected, dec16.patternAt(param.eight, param.index), param.msg)
    }

    companion object {
        private val params = listOf(
            listOf(1  , 0  , -1 , 0  , 1  , 0  , -1 , 0), // 0=1, 1=2, 2=3
            listOf(0  , 1  , 1  , 0  , 0  , -1 , -1 , 0), // 0=0, 1=1, 2=1, 3=2, 4=2, 5=3, 6=3
            listOf(0  , 0  , 1  , 1  , 1  , 0  , 0  , 0),
            listOf(0  , 0  , 0  , 1  , 1  , 1  , 1  , 0),
            listOf(0  , 0  , 0  , 0  , 1  , 1  , 1  , 1),
            listOf(0  , 0  , 0  , 0  , 0  , 1  , 1  , 1),
            listOf(0  , 0  , 0  , 0  , 0  , 0  , 1  , 1),
            listOf(0  , 0  , 0  , 0  , 0  , 0  , 0  , 1)
        )
        @JvmStatic
        fun patternParams(): List<Arguments> =
                params.mapIndexed { eight, list ->
                    list.mapIndexed { index, expected ->
                        Param(
                                expected = expected,
                                eight = eight,
                                index = index,
                                msg = "ex: $expected, eight: $eight, idx: $index"
                        )
                    }
                }.flatten().map { Arguments.of(it) }
//            return listOf(
//                    Arguments.of(1, 0, 0),
//                    Arguments.of(0, 0, 1),
//                    Arguments.of(-1, 0, 2),
//                    Arguments.of(0, 0, 5),
//                    Arguments.of(-1, 0, 6),
//
//                    Arguments.of(0, 1, 0),
//                    Arguments.of(1, 1, 2),
//                    Arguments.of(1, 1, 3),
//                    Arguments.of(0, 1, 4),
//
//                    Arguments.of(1, 3, 6),
//                    Arguments.of(0, 3, 7)
//            )
    }

    data class Param(val expected: Int, val eight: Int, val index: Int, val msg: String)
*/

    @Test
    fun simple() {
        val v = "12345678"
        val one = dec16.solve(v, 1)
        val two = dec16.solve(v, 2)
        val three = dec16.solve(v, 3)
        val four = dec16.solve(v, 4)
        assertEquals("48226158", one)
        assertEquals("34040438", two)
        assertEquals("03415518", three)
        assertEquals("01029498", four)
    }

    /*
    80871224585914546619083218645595 becomes 24176176.
     */
    @Test
    fun `one a`() {
        val v = "80871224585914546619083218645595"
        val result = dec16.solve(v, 100)
        assertEquals("24176176", result)
    }

    /*
    19617804207202209144916044189917 becomes 73745418.
     */
    @Test
    fun `one b`() {
        val v = "19617804207202209144916044189917"

        val result = dec16.solve(v, 100)
        assertEquals("73745418", result)
    }

    /*
    69317163492948606335995924319873 becomes 52432133
     */
    @Test
    fun `one c`() {
        val v = "69317163492948606335995924319873"
        val result = dec16.solve(v, 100)
        assertEquals("52432133", result)
    }

    @Test
    fun `one real`() {
        val v = "59765216634952147735419588186168416807782379738264316903583191841332176615408501571822799985693486107923593120590306960233536388988005024546603711148197317530759761108192873368036493650979511670847453153419517502952341650871529652340965572616173116797325184487863348469473923502602634441664981644497228824291038379070674902022830063886132391030654984448597653164862228739130676400263409084489497532639289817792086185750575438406913771907404006452592544814929272796192646846314361074786728172308710864379023028807580948201199540396460310280533771566824603456581043215999473424395046570134221182852363891114374810263887875638355730605895695123598637121"
        val result = dec16.solve(v, 100)
        assertEquals("70856418", result)
    }

    /*
    03036732577212944063491565474664 becomes 84462026.
02935109699940807407585447034323 becomes 78725270.
03081770884921959731165446850517 becomes 53553731.
     */
    @Test
    fun `two a`() {
        val result = dec16.solve("03036732577212944063491565474664".repeat(10_000), 100, true)
        assertEquals("84462026", result)
    }

    @Test
    fun `two b`() {}

    @Test
    fun `two c`() {}

    @Test
    fun `two real`() {}
}
