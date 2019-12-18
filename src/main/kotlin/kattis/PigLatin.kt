package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class PigLatin {
    val vowels = setOf('a', 'e', 'i', 'o', 'u', 'y')

    fun solve(scanner: Scanner): String {
        val result = mutableListOf<String>()

        while (scanner.hasNextLine()) {
            result.add(latinise(scanner.nextLine()))
        }

        return result.joinToString(separator = "\n")
    }

    private fun latinise(nextLine: String): String {
        val line = mutableListOf<String>()
        for (word in nextLine.split(" ")) {
            line.add(latin(word))
        }
        return line.joinToString(separator = " ")
    }

    private fun latin(word: String): String {
        if (word.isEmpty()) {
            return ""
        }

        var prefix = ""
        var i = 0

        while (i < word.length && !vowels.contains(word[i])) {
            prefix += word[i]
            i++
        }

        val postfix = if (i == 0) {
            "yay"
        } else {
            "ay"
        }

        return "${word.substring(i)}$prefix$postfix"
    }


}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(PigLatin().solve(scanner))
}