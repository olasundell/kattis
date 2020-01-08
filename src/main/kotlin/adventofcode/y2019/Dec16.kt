package adventofcode.y2019;

import java.lang.Math.ceil

/**
 * TODO write documentation
 */
class Dec16 {
    private val pattern = listOf(0, 1, 0, -1)

    fun solve(str: String, noOfPhases: Int): String {
        val v = str.map { (it - '0') }
        val currentArr =
        repeat (noOfPhases) { phase ->
            repeat (8) { eight ->
                v.mapIndexed { index, c -> patternAt(eight, index) * c }
            }
        }

        return ""
    }

    //    val patterns= listOf(
//            listOf(1  , 0  , -1 , 0  , 1  , 0  , -1 , 0), 0=1, 1=2, 2=3
//            listOf(0  , 1  , 1  , 0  , 0  , -1 , -1 , 0), 0=0, 1=1, 2=1, 3=2, 4=2, 5=3, 6=3
//            listOf(0  , 0  , 1  , 1  , 1  , 0  , 0  , 0),
//            listOf(0  , 0  , 0  , 1  , 1  , 1  , 1  , 0),
//            listOf(0  , 0  , 0  , 0  , 1  , 1  , 1  , 1),
//            listOf(0  , 0  , 0  , 0  , 0  , 1  , 1  , 1),
//            listOf(0  , 0  , 0  , 0  , 0  , 0  , 1  , 1),
//            listOf(0  , 0  , 0  , 0  , 0  , 0  , 0  , 1)
//    )
    fun patternAt(eight: Int, index: Int): Int {
        if (eight > index) {
            return 0
        } else if (eight == 0) {
            return pattern[(index + 1) % 4]
        }

        val i = (index - eight).toDouble()
        val e = (eight + 1).toDouble()
        val ceil = ceil(i / e)
        val toInt = ceil.toInt()
        val idx = toInt % 4

        return pattern[idx]
//        return 0
    }
}
