import java.lang.System.err
import java.math.BigInteger
import java.util.Scanner;

/**
 * TODO write documentation
 */
class ScrollingSign {
    fun solve(scanner: Scanner): String {
        val result = mutableListOf<Int>()
        val nCases = scanner.nextInt()
        repeat(nCases) {
            val len = scanner.nextInt()
            val n = scanner.nextInt()
            val strings = (1..n).map {
                scanner.next()
            }
            result.add(compute(strings))
        }
        return result.joinToString(separator = "\n")
    }

    private fun compute(strings: List<String>): Int {
        val reduce = strings.reduce { acc, s -> reduceStrings(acc, s) }
        err.println(reduce)
        return reduce.length
    }

    fun reduceStrings(left: String, right: String): String {
        val first = reversedBitChecksum(left, left.length - right.length)
        val second = bitChecksum(right)

        val pos = match(first, second)
        return concat(left, right, pos)
    }

    fun concat(left: String, right: String, pos: Int): String = left + right.substring(pos + 1)

    fun match(one: Map<BigInteger, Int>, two: Map<BigInteger, Int>): Int {
        val sortedTwo: List<Pair<Int, BigInteger>> = transformAndSort(two)

        for (f in sortedTwo) {
            if (one.contains(f.second)) {
                return f.first
            }
        }

        return -1
    }

    private fun transformAndSort(map: Map<BigInteger, Int>) = map.map { entry -> entry.value to entry.key }.sortedByDescending { it.first }

    fun reversedBitChecksum(str: String, start: Int = 0): Map<BigInteger, Int> {
        val map = mutableMapOf<BigInteger, Int>()
        var prev = BigInteger.ZERO

        for (i in (str.length - 1) downTo start) {
//            val v = (str[i] - 'A' + 1).toBigInteger()
            val v = str[i].toInt().toBigInteger()
            val element = v + prev.shiftLeft(8)
            map[element] = i
            prev = element
        }

        return map

    }

    fun bitChecksum(str: String, start: Int = 0): Map<BigInteger, Int> {
        val map = mutableMapOf<BigInteger, Int>()
        var prev = BigInteger.ZERO

        for (i in start until str.length) {
            val v = str[i].toInt().toBigInteger()
            val element = v.shiftLeft(i * 8) + prev
            map[element] = i
            prev = element
        }

        return map
    }

//    fun prefixSuffixed(left: String, right: String): String {
//        var len = right.length
//        for (i in left.length - right.length until left.length) {
//            for (j in i until left.length) {
//                if (left[j] != right[j - i]) {
//                    len--
//                    break
//                }
//            }
//        }
//
//        return left.substring(0, left.length - len) + right
//    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(ScrollingSign().solve(scanner))
}
