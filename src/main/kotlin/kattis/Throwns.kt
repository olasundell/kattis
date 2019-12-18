package kattis

import java.util.*

/**
 * TODO write documentation
 */
class Throwns {
    fun solve(scanner: Scanner): String {
        val noOfStudents = scanner.nextInt()
        val noOfCmds = scanner.nextInt()
        val commands = mutableListOf(0)

        for (i in 0 until noOfCmds) {
            val s = scanner.next()
            if (s == "undo") {
                val undos = scanner.nextInt()
                for (j in 0 until undos) {
                    commands.removeAt(0)
                }
            } else {
                val currentPos = commands.first()
                commands.add(0, calcPos(currentPos, s.toInt(), noOfStudents))
            }
        }

        return commands.first().toString()
    }

    private fun calcPos(currentPos: Int, steps: Int, noOfStudents: Int): Int {
        return (currentPos + (noOfStudents + steps % noOfStudents)) % noOfStudents
    }

}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Throwns().solve(scanner))
}