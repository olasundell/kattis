package kattis;

import java.util.Scanner;

/**
 *  𝑌 is menolaxios and 𝑃 is mox, the extended name is 𝚖𝚎𝚗𝚘𝚕𝚊𝚡𝚒𝚘𝚜+𝚎𝚡+𝚖𝚘𝚡=𝚖𝚎𝚗𝚘𝚕𝚊𝚡𝚒𝚘𝚜𝚎𝚡𝚖𝚘𝚡
 * If 𝑌 ends with e, then the extended name is 𝑌+𝚡+𝑃

If 𝑌 ends with any other vowel (a,i,o, or u), we remove that final vowel from 𝑌, and then extend 𝑌 with 𝚎𝚡+𝑃

If 𝑌 already ends with ex, then the extended name is simply 𝑌+𝑃.
 */
class ApaxianParent {
    fun solve(scanner: Scanner): String {
        val y = scanner.next()
        val p = scanner.next()

        return if (y.endsWith("e")) {
            "${y}x$p"
        } else if (listOf('a', 'i', 'o', 'u').contains(y.last())) {
            "${y.substring(0, y.length - 1)}ex$p"
        } else if (y.endsWith("ex")) {
            "$y$p"
        } else {
            "${y}ex$p"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(ApaxianParent().solve(scanner))
}