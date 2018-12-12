package adventofcode.y2018;

import java.lang.System.out
import java.util.*

class Dec11 {
    fun solve(scanner: Scanner): String {
        val salt = scanner.nextInt()
        val array = initArray(salt)

        var max = Int.MIN_VALUE
        var pair = Pair(-1, -1)

        for (x in 0 until 298) {
            for (y in 0 until 298) {
                val sum: Int = sumArray(x, y, array, 2)
                if (sum > max) {
                    max = sum
                    pair = Pair(x + 1, y + 1)
                }
            }
        }

        return pair.toString()
    }

    fun solve2(scanner: Scanner): String {
        val salt = scanner.nextInt()
        val array = initArray(salt)

        var max = Int.MIN_VALUE
        var triple = Triple(-1, -1, -1)

        for (size in 1..300) {
            out.println(size)
            for (x in 0 until (300 - size)) {
                for (y in 0 until (300 - size)) {
                    val sum: Int = sumArray(x, y, array, size)
                    if (sum > max) {
                        max = sum
                        triple = Triple(x + 1, y + 1, size + 1)
                    }
                }
            }
        }

        return triple.toString()
    }

    private fun initArray(salt: Int): Array<IntArray> {
        val array = Array<IntArray>(300) { IntArray(300) { 0 } }

        for (x in 0 until 300) {
            for (y in 0 until 300) {
                array[x][y] = init(x + 1, y + 1, salt)
            }
        }
        return array
    }

    private fun sumArray(x: Int, y: Int, array: Array<IntArray>, size: Int): Int {
        var sum = 0

        for (i in x..(x + size)) {
            for (j in y..(y + size)) {
                sum += array[i][j]
            }
        }

        return sum
    }


    fun init(x: Int, y: Int, salt: Int): Int {
        val rackId = x + 10
        val powerLevel = rackId * y
        val pLvlSerial = powerLevel + salt
        val multiplied = pLvlSerial * rackId
        val hundred = (multiplied % 1000) / 100

        return hundred - 5
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec11().solve(scanner))
}