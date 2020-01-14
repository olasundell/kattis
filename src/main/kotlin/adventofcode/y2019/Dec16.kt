package adventofcode.y2019;

import java.lang.Integer.min
import java.lang.Math.abs
import java.lang.Math.ceil

/**
 * TODO write documentation
 */
class Dec16 {
    private val pattern = listOf(0, 1, 0, -1)
//    private val pattern = listOf(1, 0, -1, 0)

    fun solve(str: String, noOfPhases: Int, offset: Boolean = false): String {
        val v = str.map { (it - '0') }
        var currentArr = v.toList()
        var nextArr = currentArr.toMutableList()

        println("size ${v.size}")

        repeat (noOfPhases) { phase ->
            repeat (currentArr.size) { i ->
                var s = 0
                var j = i
                var total = 0
                while (j < currentArr.size) {
                    val s = currentArr.subList(min(j, currentArr.size), min(j + i + 1, currentArr.size))
                    total += s.sum()
                    j += 2 * (i + 1)
                    val s2 = currentArr.subList(min(j, currentArr.size), min(j + i + 1, currentArr.size))
                    total -= s2.sum()
                    j += 2 * (i + 1)
                }
                nextArr[i] = abs(total) % 10
                if (i % 1_000 == 0) {
                    println("$phase $i")
                }
            }
            currentArr = nextArr.toList()
        }

        return if (offset) {
            val o = v.subList(0, 7).sum()
//            val arr = listOf(currentArr, currentArr).flatten()
            currentArr.subList(o, o + 8)
        } else {
            currentArr.subList(0, 8)
        }.joinToString(separator = "")
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
        val p = index - eight
//        val i = p % 4
        val d = p.toDouble() / eight.toDouble()
        val ceil = ceil(d)
        val idx = ceil.toInt() % 4

        return pattern[idx]
    }
//
//        val i = (index - eight).toDouble()
//        val e = (eight + 1).toDouble()
//        val ceil = kotlin.math.ceil(i / e)
//        val toInt = ceil.toInt()
//        val idx = toInt % 4
//
}
