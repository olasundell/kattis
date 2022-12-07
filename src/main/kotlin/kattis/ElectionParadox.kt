package kattis;

import java.util.Scanner;
import kotlin.math.floor

/**
 * TODO write documentation
 */
class ElectionParadox {
	fun solve(scanner: Scanner): String {
		val n1 = scanner.next()
		val n2 = scanner.next()

		val x = n2.foldIndexed(1) { index, acc, c -> if (n1[index] != c) acc * 2 else acc }

		return "$x"


        val n = scanner.nextInt()
        val districts = (0 until n).map { scanner.nextInt() }.sorted().reversed()

        val largeD = districts.subList(0, districts.size / 2)
        val smallD = districts.subList(districts.size / 2, districts.size)

        val sum = largeD.sum() + smallD.map { floor(it / 2.0).toInt() }.sum()

        return "$sum"
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(ElectionParadox().solve(scanner))
}