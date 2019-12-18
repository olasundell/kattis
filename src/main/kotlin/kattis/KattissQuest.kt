package kattis

import java.util.*

/**
 * TODO write documentation
 */
class KattissQuest {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextInt()

        val tasks = TreeMap<Int, PriorityQueue<Int>>()
        val results = mutableListOf<Int>()

        repeat (n) {
            val cmd = scanner.next()
            if ("add" == cmd) {
                val energy = scanner.nextInt()
                val gold = scanner.nextInt()
                tasks.putIfAbsent(energy, PriorityQueue(reverseOrder<Int>()))
                tasks[energy]!!.add(gold)
            } else {
                var max = scanner.nextInt()
                var gold = 0
                var head = tasks.headMap(max + 1)
                while (head.isNotEmpty()) {
                    val last = head.lastKey()
                    max -= last
                    val queue = head[last]!!
                    gold += queue.remove()

                    if (queue.isEmpty()) {
                        head.remove(last)
                        tasks.remove(last)
                    }

                    head = head.headMap(max + 1)
                }

                results.add(gold)
            }
        }

        return results.joinToString(separator="\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(KattissQuest().solve(scanner))
}