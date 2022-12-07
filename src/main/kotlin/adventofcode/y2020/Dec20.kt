package adventofcode.y2020;

import adventofcode.y2020.Dec12.Dir
import adventofcode.y2020.Dec12.Dir.*
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec20 {
    fun solve(scanner: Scanner): String {
        val tiles = mutableListOf<Tile>()
        while (scanner.hasNextLine()) {
            val rId = "Tile (?<id>\\d+):".toRegex()
            val line = scanner.nextLine()
            val matchEntire = rId.matchEntire(line)
            val id = matchEntire!!.groups["id"]!!.value.toInt()

            val t = (1..10).map { scanner.nextLine() }

            tiles.add(createTile(id, t))
            if (scanner.hasNextLine()) {
                scanner.nextLine()
            }
        }

        val nums = mutableMapOf<Int, Int>()

        tiles.forEach {
            it.sides.values.forEach { i -> nums[i] = (nums[i] ?: 0) + 1  }
            it.revSides.values.forEach { i -> nums[i] = (nums[i] ?: 0) + 1  }
        }

        return ""
    }

    private fun createTile(id: Int, t: List<String>): Tile {
        val map = mapEdges(t)
        val revMap = revMapEdges(t)

        return Tile(id, map, revMap)
    }

    private fun revMapEdges(t: List<String>): Map<Dir, Int> {
        val north = t[0].reversed().edge()
        val south = t[9].edge()

        val east = (0 until 10).fold("") { acc, i ->
            acc + t[9 - i][0]
        }.edge()
        val west = (0 until 10).fold("") { acc, i ->
            acc + t[i][9]
        }.edge()

        return mapOf(N to north, S to south, E to east, W to west)
    }

    private fun mapEdges(t: List<String>): Map<Dir, Int> {
        val north = t[0].edge()
        val south = t[9].reversed().edge()

        val east = (0 until 10).fold("") { acc, i ->
            acc + t[i][9]
        }.edge()
        val west = (0 until 10).fold("") { acc, i ->
            acc + t[9 - i][0]
        }.edge()

        return mapOf(N to north, S to south, E to east, W to west)
    }

    fun String.edge(): Int = this.replace('.', '0').replace('#', '1').toInt(2)

    data class Tile(val id: Int, val sides: Map<Dir, Int>, val revSides: Map<Dir, Int>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec20().solve(scanner))
}