package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */

data class Proof(val conclusion: String, val assumptions: List<String>) {
    fun isAxiom(): Boolean = assumptions.isEmpty()
}

class Proofs {
    fun solve(scanner: Scanner): String {
        val n = scanner.nextLine().toInt()
//        val proofs: Map<String, List<String>> = mutableMapOf()
        val proofs: MutableSet<String> = mutableSetOf()
        var errors = 0

        for (i in (1..n)) {
            val line = scanner.nextLine()
            val p = proofify(line)
            if (p.isAxiom() || proofs.containsAll(p.assumptions)) {
                proofs.add(p.conclusion)
            } else {
                return i.toString()
            }
        }

        return "correct"
    }

    fun proofify(line: String): Proof {
        return if (line.startsWith("->")) {
            Proof(line.removePrefix("-> "), listOf())
        } else {
            val parts = line.split(" -> ")
            Proof(parts[1], parts[0].split(" "))
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    println(Proofs().solve(scanner))
}