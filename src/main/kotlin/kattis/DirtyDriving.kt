package kattis

import java.util.*

class DirtyDriving {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        val p = scanner.nextInt()
        val cars = sortedSetOf<Int>()

        for (i in 1..n) {
            cars.add(scanner.nextInt())
        }


        var brakingDistance = -1
        var first = cars.first()
        for (i in 0 until n) {
            val d = cars.pollFirst()

            brakingDistance = Math.max(p * (i + 1) - d, brakingDistance)
        }

        return (brakingDistance + first).toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(DirtyDriving().solve(scanner))
}