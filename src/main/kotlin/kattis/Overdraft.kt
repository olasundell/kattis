package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Overdraft {
	fun solve(scanner: Scanner): String {
        var s = 0
        var min = 0
        while(scanner.hasNextLine()) {
            s += scanner.nextLine().toInt()
            min = s.coerceAtMost(min)
        }

		return "${-min}"
	}
}

fun main(args: Array<String>) {
	val scanner = Scanner(System.`in`)
	System.out.println(Overdraft().solve(scanner))
}