package adventofcode.y2019;

import kotlinx.coroutines.runBlocking
import java.util.*

/**
 * TODO write documentation
 */
class Dec7 {
    fun solve(scanner: Scanner): String {
        val memory = scanner.nextLine().split(",").map { it.toLong() }

        val permutations = permute(listOf(0, 1, 2, 3, 4))

        var max = Int.MIN_VALUE
        val results = mutableListOf<Int>()

        runBlocking {
            for (p in permutations) {
                var last = 0
                val list = mutableListOf<Int>(0)
                for (i in 0..4) {
                    last = Dec5().runProgram(memory, listOf(p[i], last)).toInt()
                    list.add(last)
                }
                results.add(last)
//            results.add(p.fold(0) { acc: Int, i: Int -> Dec5().runProgram(memory, listOf(i, acc))[0] })
//            val one = Dec5().runProgram(memory, listOf(p[0], 0))[0]
//            Dec5().runProgram(memory, listOf(p[1], one))
            }
        }

//        val mapped: List<Int> = permutations.map { Dec5().runProgram(memory.toMutableList(), it)[0] }

//        return output.joinToString(separator = "\n")

        return "${results.maxOrNull()}"
//        return "-1"
//        return "${mapped.max()}"
    }

    fun permute(input: List<Int>): List<List<Int>> {
        if (input.size == 1) return listOf(input)
        val perms = mutableListOf<List<Int>>()
        val toInsert = input[0]
        for (perm in permute(input.drop(1))) {
            for (i in 0..perm.size) {
                val newPerm = perm.toMutableList()
                newPerm.add(i, toInsert)
                perms.add(newPerm)
            }
        }
        return perms
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec7().solve(scanner))
}