package kattis;

import java.util.Scanner
import java.util.PriorityQueue
import kotlin.Comparator

/**
 * TODO write documentation
 */
class RaidTeams {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextLine()

        val pq1 = PriorityQueue { o1: Player, o2: Player -> o2.skill1 - o1.skill1 }
        val pq2 = PriorityQueue { o1: Player, o2: Player -> o2.skill2 - o1.skill2 }
        val pq3 = PriorityQueue { o1: Player, o2: Player -> o2.skill3 - o1.skill3 }

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine().split(" ")
            val player = Player(line[0], line[1].toInt(), line[2].toInt(), line[3].toInt())
            listOf(pq1, pq2, pq3).forEach { it.add(player) }
        }

        val teams = mutableListOf<List<Player>>()

        while (pq1.size > 2) {
            val p1 = pq1.first()
            listOf(pq1, pq2, pq3).forEach { it.remove(p1) }

            val p2 = pq2.first()
            listOf(pq1, pq2, pq3).forEach { it.remove(p2) }

            val p3 = pq3.first()
            listOf(pq1, pq2, pq3).forEach { it.remove(p3) }

            teams.add(listOf(p1, p2, p3).sortedWith { pn1, pn2 -> pn1.name.compareTo(pn2.name) })
        }

        return teams.joinToString(separator = "\n") { it.joinToString(separator = " ") { it2 -> it2.name } }
    }

    data class Player(val name: String, val skill1: Int, val skill2: Int, val skill3: Int)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(RaidTeams().solve(scanner))
}