package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Exam {
    fun solve(scanner: Scanner): String {
        val nCorr = scanner.nextInt()
        val myLine = scanner.next()
        val friendLine = scanner.next()

        val diff = myLine.foldIndexed(0) {
            index, acc, c -> if (c != friendLine[index]) { acc + 1 } else { acc }
        }

        val wrong = friendLine.length - nCorr

        return if (diff > wrong) {
            (myLine.length - diff + wrong).toString()
        } else {
            (nCorr + diff).toString()
        }
    }
}

/*
1
T
F
diff - nCorr == 0

2
TT
TF

2
TTT
TTF

3
TTT
TTF

5
TTTTT
TTTFF

3
TTT
FFF

3
FTFFF
TFTTT

diff = 5
diff - nCorr
 */

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Exam().solve(scanner))
}