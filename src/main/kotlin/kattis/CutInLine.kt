package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class CutInLine {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()
        scanner.nextLine()

        val list = (1..n).map { scanner.nextLine() }.toMutableList()
        val n2 = scanner.nextInt()
        scanner.nextLine()

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine().split(" ")
            if (line[0] == "cut") {
                list.add(list.indexOf(line[2]), line[1])
            } else {
                list.remove(line[1])
            }
        }

        return list.joinToString("\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(CutInLine().solve(scanner))
}