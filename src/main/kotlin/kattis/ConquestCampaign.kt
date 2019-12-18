package kattis

import java.util.Scanner;

/**
 * TODO write documentation
 */
class ConquestCampaign {
    fun solve(scanner: Scanner): String {
        val xSize = scanner.nextInt()
        val ySize = scanner.nextInt()
        val noOfGivenPoints = scanner.nextInt()

        val board: Array<Array<Int>> = Array(xSize) { Array(ySize){ 0 } }

        var days = 1

        for (i in 1..noOfGivenPoints) {
            val x = scanner.nextInt() - 1
            val y = scanner.nextInt() - 1

            board[x][y] = days
        }

        var updated = true

        while (updated) {
            updated = false
            for (x in 0 until xSize) {
                for (y in 0 until ySize) {
                    if (board[x][y] == days) {
                        updated = update(x, y, board, days) || updated
                    }
                }
            }
            if (updated) {
                days++
            }
        }

        return days.toString()
    }

    private fun update(x: Int, y: Int, board: Array<Array<Int>>, days: Int): Boolean {
        var updated = false
        if (board[x][y] == 0) {
            return false
        }

//        if (board[x][y] == days) {
            if (x > 0) {
                if (board[x - 1][y] == 0) {
                    updated = true
                    board[x - 1][y] = days + 1
                }
            }

            if (x < board.size - 1) {
                if (board[x + 1][y] == 0) {
                    updated = true
                    board[x + 1][y] = days + 1
                }
            }

            if (y > 0) {
                if (board[x][y - 1] == 0) {
                    updated = true
                    board[x][y - 1] = days + 1
                }
            }

            if (y < board[x].size - 1) {
                if (board[x][y + 1] == 0) {
                    updated = true
                    board[x][y + 1] = days + 1
                }
            }
//        }

        return updated
    }

}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(ConquestCampaign().solve(scanner))
}