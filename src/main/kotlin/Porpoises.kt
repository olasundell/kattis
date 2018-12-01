import java.util.Scanner;
import java.math.BigInteger



/**
 * TODO write documentation
 */
class Porpoises() {
    val map = sortedMapOf<Long, Long>()

    init {
        map[1] = 0
        map[2] = 1
        map[3] = 1
    }
    fun solve(scanner: Scanner): String {

        val n = scanner.nextInt()
        val results = mutableListOf<String>()

        for (i in 1..n) {
            val num = scanner.nextInt()
            val k = scanner.nextLong() + 1

            val element = "$num ${calcAt(k)}"
            println(element)
            results.add(element)
        }

        return results.joinToString(separator = "\n")
    }

    fun calcAt(k: Long): Long {
        return fib(k)
//        return fastFibonacciDoubling(k).toLong()
//        return calc(k)
//        return rawCalc(k % 45000)
    }

    private fun rawCalc(k: Long): Long {
        var prev: Long = 0
        var sum: Long = 1

        for (i in 1 until k) {
            val newSum = (sum + prev) % 1_000_000_000
            prev = sum
            sum = newSum
        }

        return sum

    }

    private fun calc(k: Long) : Long {
        val lastKey = map.headMap(k).lastKey()

        var prev = map[lastKey - 1]!!
        var sum = map[lastKey]!!

        for (i in lastKey + 1 until k) {
            val newSum = (sum + prev) % 1_000_000_000
            prev = sum
            sum = newSum
            map[i] = sum
        }

        return sum
    }

    private fun fib(n: Long): Long {
        if (map.containsKey(n)) {
            return map[n]!!
        }
        val x: Long = if (n % 2 == 0L) {
            (fib(n / 2 + 1) * fib(n / 2 + 1) + fib(n / 2) * fib(n / 2)) % 1_000_000_000
        } else {
            (2 * fib(n / 2) * fib(n / 2 + 1) + fib(n / 2 + 1) * fib(n / 2 + 1)) % 1_000_000_000
        }

        map[n] = x
        return x
    }

    private fun fastFibonacciDoubling(n: Long): BigInteger {
        var a = BigInteger.ZERO
        var b = BigInteger.ONE
        var m = 0
        var bit = java.lang.Long.highestOneBit(n)
        while (bit != 0L) {

            // Double it
            val d = multiply(a, b.shiftLeft(1).subtract(a))
            val e = multiply(a, a).add(multiply(b, b))
            a = d
            b = e
            m *= 2
            // Advance by one conditionally
            if (n and bit != 0L) {
                val c = a.add(b)
                a = b
                b = c
                m++
            }
            bit = bit ushr 1
        }
        return a
    }

    private val CUTOFF = 1536

    private fun multiply(x: BigInteger, y: BigInteger): BigInteger {
        if (x.bitLength() <= CUTOFF || y.bitLength() <= CUTOFF) {  // Base case
            return x.multiply(y)

        } else {
            val n = Math.max(x.bitLength(), y.bitLength())
            val half = (n + 32) / 64 * 32  // Number of bits to use for the low part
            val mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE)
            val xlow = x.and(mask)
            val ylow = y.and(mask)
            val xhigh = x.shiftRight(half)
            val yhigh = y.shiftRight(half)

            val a = multiply(xhigh, yhigh)
            val b = multiply(xlow.add(xhigh), ylow.add(yhigh))
            val c = multiply(xlow, ylow)
            val d = b.subtract(a).subtract(c)
            return a.shiftLeft(half).add(d).shiftLeft(half).add(c)
        }
    }

//    private fun multiply(x: BigInteger, y: BigInteger): BigInteger {
//        return x.multiply(y)
//    }


    /*
    private fun fastFibonacciDoubling(n: Long): BigInteger {
        var a = BigInteger.ZERO
        var b = BigInteger.ONE
        var m = 0
        var bit = Integer.highestOneBit(n)
        while (bit != 0) {
            // Loop invariant: a = F(m), b = F(m+1)
//            assert(a == slowFibonacci(m))
//            assert(b == slowFibonacci(m + 1))

            // Double it
            val d = multiply(a, b.shiftLeft(1).subtract(a))
            val e = multiply(a, a).add(multiply(b, b))
            a = d
            b = e
            m *= 2
//            assert(a == slowFibonacci(m))
//            assert(b == slowFibonacci(m + 1))

            // Advance by one conditionally
            if (n and bit != 0) {
                val c = a.add(b)
                a = b
                b = c
                m++
//                assert(a == slowFibonacci(m))
//                assert(b == slowFibonacci(m + 1))
            }
            bit = bit ushr 1
        }
        return a
    }


    // Requirement: CUTOFF >= 64, or else there will be infinite recursion.
    private val CUTOFF = 1536

    // Multiplies two BigIntegers. This function makes it easy to swap in a faster algorithm like Karatsuba multiplication.
    private fun multiply(x: BigInteger, y: BigInteger): BigInteger {
        return x.multiply(y)
    }

*/
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Porpoises().solve(scanner))
}