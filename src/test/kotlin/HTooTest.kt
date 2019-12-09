import org.junit.Assert
import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class HTooTest : AbstractKotlinTest() {
    @Test
    fun shouldParseMolecule() {
        val hToo = HToo()

//        var map = hToo.parseMolecule("O")
//
//        assertEquals(1, map.size)
//        assertEquals(1, map['O'])
//
//        map = hToo.parseMolecule("H6")
//
//        assertEquals(1, map.size)
//        assertEquals(6, map['H'])

        var map = hToo.parseMolecule("H7C12")

        assertEquals(2, map.size)
        assertEquals(7, map['H'])
        assertEquals(12, map['C'])

        map = hToo.parseMolecule("NHH7C12")

        assertEquals(3, map.size)
        assertEquals(1, map['N'])
        assertEquals(8, map['H'])
        assertEquals(12, map['C'])
    }
    @Test
    fun one() {
        runTest(1, HToo()::solve)
    }

    @Test
    fun two() {
        runTest(2, HToo()::solve)
    }

    @Test
    fun three() {
        runTest(3, HToo()::solve)
    }

    @Test
    fun four() {
        runTest(4, HToo()::solve)
    }

    @Test
    fun five() {
        runTest(5, HToo()::solve)
    }

    @Test
    fun six() {
        runTest(6, HToo()::solve)
    }
}
