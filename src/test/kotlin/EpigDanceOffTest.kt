import kattis.EpigDanceOff
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class EpigDanceOffTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, EpigDanceOff()::solve)
    }

    @Test
    fun two() {
        runTest(2, EpigDanceOff()::solve)
    }

    @Test
    fun three() {
        runTest(3, EpigDanceOff()::solve)
    }

//    @Test
//    fun writeFile() {
//        var line = ""
//
//        repeat(2_000) {
//            line += "_"
//        }
//
//        var str = "2000 2000\n"
//
//        repeat(1_999) {
//            str += "$line\n"
//        }
//
//        str += line
//
//        val file = File("/tmp/3.in")
//
//        file.writeText(str)
//    }
}