package adventofcode.y2020;

import java.util.*

/**
 * TODO write documentation
 */
class Dec16 {
    fun solve(scanner: Scanner): String {
        val state = readState(scanner)

        val wrong = findWrongValues(state.rules, state.nearbyTickets)

        return "${wrong.sum()}"
    }

    fun solve2(scanner: Scanner): String {
        val state = readState(scanner, filtered = true)

        val applied = mapRulesToColumn(state)

        val cols = applied.filter { it.value.startsWith("departure") }.map { it.key }
        val sum = cols.map { state.yourTicket[it].toLong() }.reduce { acc, i -> acc * i }

        return "$sum"
    }

    fun mapRulesToColumn(state: State): Map<Int, String> {
        val ruled = mutableMapOf<Int, List<String>>()

        for (col in state.nearbyTickets[0].indices) {
            val fold = state.nearbyTickets.fold(listOf<Int>()) { acc, list -> acc + list[col] }
            val filtered = state.rules.filter { rule -> fold.count { !rule.value.contains(it) } == 0 }
            ruled[col] = filtered.map { it.key }
        }

        var notYetRuled = ruled.filterNot { it.value.size == 1 }

        while (notYetRuled.isNotEmpty()) {
            val hasBeenRuled = ruled.values.filter { it.size == 1 }.reduce { acc, list -> acc + list }
            notYetRuled.forEach { (t, u) ->  ruled[t] = u.filterNot { hasBeenRuled.contains(it) } }

            notYetRuled = ruled.filterNot { it.value.size == 1 }
        }

        return ruled.map { entry -> entry.key to entry.value[0] }.toMap()
    }

    private fun readState(scanner: Scanner, filtered: Boolean = false): State {
        val rules = readRules(scanner)
        scanner.nextLine()

        val yourTicket = readTicket(scanner)

        scanner.nextLine()

        val nearbyTickets = mutableListOf<List<Int>>()

        scanner.nextLine()

        while (scanner.hasNextLine()) {
            val ticket = readTicket(scanner)
            if (filtered) {
                if (findWrongValues(rules, listOf(ticket)).isEmpty()) {
                    nearbyTickets.add(ticket)
                }
            } else {
                nearbyTickets.add(ticket)
            }
        }

        return State(
            rules = rules,
            yourTicket = yourTicket,
            nearbyTickets = nearbyTickets
        )
    }

    fun findWrongValues(rules: Map<String, Rule>, nearbyTickets: List<List<Int>>): List<Int> =
        nearbyTickets.fold(listOf()) { acc, list -> acc + list.filterNot { isValidValue(it, rules) } }

    fun isValidValue(i: Int, rules: Map<String, Rule>): Boolean =
        rules.values.count { it.contains(i) } > 0

    private fun readTicket(scanner: Scanner) = scanner.nextLine().split(",").map { it.toInt() }

    fun readRules(scanner: Scanner): Map<String, Rule> {
        val rule = "(?<name>[\\w ]+): (?<r1s>\\d+)-(?<r1e>\\d+) or (?<r2s>\\d+)-(?<r2e>\\d+)".toRegex()
        val map = mutableMapOf<String, Rule>()
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            if (line.isBlank()) {
                return map
            }

            val m = rule.matchEntire(line)!!
            map[m.groups["name"]!!.value] = Rule(
                IntRange(m.groups["r1s"]!!.value.toInt(), m.groups["r1e"]!!.value.toInt()),
                IntRange(m.groups["r2s"]!!.value.toInt(), m.groups["r2e"]!!.value.toInt())
            )
        }
        return mapOf()
    }

    data class Rule(val first: IntRange, val second: IntRange)
    fun Rule.contains(i: Int) = first.contains(i) || second.contains(i)

    data class State(val rules: Map<String, Rule>, val yourTicket: List<Int>, val nearbyTickets: List<List<Int>>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec16().solve(scanner))
}
