package adventofcode.y2018;

import java.lang.System.out
import java.util.*

class Dec9 {
    fun solve(scanner: Scanner): String {
        val noOfPlayers = scanner.nextInt()
        val maxStone = scanner.nextInt()
        val players = LongArray(noOfPlayers) { 0 }
        val stones = LinkedList<Int>()

        stones.add(0)

        for (i in 1..maxStone) {
            if (i % 10_000 == 0) {
                out.println("$i")
            }
            if (i % 23 == 0) {
                // magic happens
                val i1 = i % noOfPlayers
                rotate(stones, -7)
                players.set(i1, players[i1] + i + stones.pop())
            } else {
                rotate(stones, 2)
                stones.addLast(i)
            }
//                idx = (stones.size + idx - 7) % stones.size
//                players[player] += stones[idx]
//                stones.removeAt(idx)
//                // in case we're about to fall off the edge
//                idx = idx % stones.size
//            } else {
//                idx = (idx + 2) % (stones.size + 1)
//                if (idx == 0) {
//                    stones.add(i)
//                } else {
//                    stones.add(idx, i)
//                }
//            }
        }

        players.sortDescending()

        return "high score is ${players[0]}"
    }
    private fun rotate(queue: Deque<Int>, amount: Int) {
        if (amount >= 0) {
            for (i in 0 until amount) {
                queue.addFirst(queue.removeLast())
            }
        } else {
            for (i in 0 until -amount - 1) {
                queue.addLast(queue.remove())
            }
        }
    }

//        val stones = mutableListOf<Int>()
//
//        stones.add(0)
//        stones.add(1)
//        var idx = 1
//        var player = 1
//
//        for (i in 2..maxStone) {
//            if (i % 10_000 == 0) {
//                out.println("$i")
//            }
//            if (i % 23 == 0) {
//                // magic happens
//                players[player] += i
//                idx = (stones.size + idx - 7) % stones.size
//                players[player] += stones[idx]
//                stones.removeAt(idx)
//                // in case we're about to fall off the edge
//                idx = idx % stones.size
//            } else {
//                idx = (idx + 2) % (stones.size + 1)
//                if (idx == 0) {
//                    stones.add(i)
//                } else {
//                    stones.add(idx, i)
//                }
//            }
//
//            printState(stones, player, i)
//
//            player = (player + 1) % noOfPlayers
//        }
//
//        players.sortDescending()
//
//        return "high score is ${players[0]}"
//    }
//
//    private fun printState(stones: List<Int>, player: Int, i: Int) {
//        val s = stones.map { if (it == i) { "($it)" } else { it.toString() } }
//                .map{ it.padStart(2, ' ').padEnd(2, ' ') }
//                .joinToString(" ")
//
//        out.println("[${(player + 1).toString().padStart(2, ' ')}] $s")
//    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec9().solve(scanner))
}