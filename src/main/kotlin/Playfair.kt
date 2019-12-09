import java.util.Scanner;

/**
 * To encrypt a message, one would remove all spaces and then break the message into digraphs (groups of 2 2 letters)
 * such that, for example, “Hello World” becomes “HE LL OW OR LD”.
 * Then map them out on the key table, and apply the rule below that matches the letter combination:
 *
 * If both letters are the same (or only one letter is left), add an ‘X’ after the first letter.
 * Encrypt the new pair and continue (note that this changes all the remaining digraphs).
 *
 * If the letters appear on the same row of your table, replace them with the letters to their immediate right respectively
 * (wrapping around to the left side of the row if a letter in the original pair was on the right side of the row).
 * With the table above, the digraph ‘CH’ would be encrypted ‘DB’.
 *
 * If the letters appear on the same column of your table, replace them with the letters immediately below respectively
 * (wrapping around to the top side of the column if a letter in the original pair was on the bottom side of the column).
 * With the table above, the digraph ‘VA’ would be encrypted ‘AE’.
 *
 * If the letters are not on the same row or column, replace them with the letters on the same row respectively
 * but at the other pair of corners of the rectangle defined by the original pair.
 *
 * The order is important – the first letter of the encrypted pair is the one that lies on the same row as the first letter of the plaintext pair.
 * With the table above, the digraph ‘KM’ would be encrypted ‘SR’.
 *
 */

class Playfair {
    fun solve(scanner: Scanner): String {
        val key = scanner.nextLine().replace(" ", "").toUpperCase()
        val phrase = scanner.nextLine().replace(" ", "").toUpperCase()
        return encrypt(key, phrase)
    }

    fun encrypt(key: String, phrase: String): String {
        val matrix = matrix(key)
        var str = ""

        var phr = phrase

        while (phr.isNotEmpty()) {
            if (phr.length == 1 || phr[0] == phr[1]) {
//            If both letters are the same (or only one letter is left), add an ‘X’ after the first letter.
//            Encrypt the new pair and continue (note that this changes all the remaining digraphs).
                phr = phr.substring(0, 1) + 'X' + phr.substring(1)
            }

            str += encryptTwo(phr[0], phr[1], matrix)
            phr = phr.substring(2)
        }

        return str
    }

    fun encryptTwo(first: Char, second: Char, matrix: Matrix): String {
        val pos1 = matrix.where(first)
        val pos2 = matrix.where(second)

        val pair = if (pos1.first == pos2.first) {
            Pair(matrix.get(pos1.first, (pos1.second + 1) % 5), matrix.get(pos2.first, (pos2.second + 1) % 5))
        } else if (pos1.second == pos2.second) {
            Pair(matrix.get((pos1.first + 1) % 5, pos1.second), matrix.get((pos2.first + 1) % 5, pos2.second))
        } else {
            Pair(matrix.get(pos1.first, pos2.second), matrix.get(pos2.first, pos1.second))
        }
        return "${pair.first}${pair.second}"
    }

    fun matrix(key: String): Matrix {
        val m = Matrix()
        val lettersRemaining = mutableSetOf<Char>()
        'A'.rangeTo('Z').filterNot { it == 'Q' }.forEach{ lettersRemaining.add(it) }


        var idx = 0

        for (c in key) {
            if (lettersRemaining.contains(c)) {
                lettersRemaining.remove(c)
                m.put(c, idx++)
            }
        }

        lettersRemaining.sorted().forEach { m.put(it, idx++) }

        return m
    }

    class Matrix {
        private val m = Array(5) { CharArray(5) }
        private val map = mutableMapOf<Char, Pair<Int, Int>>()
        private val rMap = mutableMapOf<Pair<Int, Int>, Char>()

        fun put(c: Char, idx: Int) {
            val i = idx / 5
            val j = idx % 5
            m[i][j] = c
            val pair = Pair(i, j)
            map[c] = pair
            rMap[pair] = c
        }

        fun where(c: Char): Pair<Int, Int> = map[c]!!

        fun get(x: Int, y: Int): Char = rMap[Pair(x, y)]!!
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Playfair().solve(scanner))
}
