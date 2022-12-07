package adventofcode.y2019;

import java.lang.IllegalStateException
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec14 {
    val amountOfOreConsumers = mutableMapOf<String, Long>()

    fun solve(scanner: Scanner): String {
        val totality = createReactionMap(scanner)

        val toCalc = mutableSetOf<Reaction>()
        toCalc.addAll(totality.reactionMap.values)

        var fuel = 0

//        while (!onlyOreReactionsLeft(totality.oreConsumers, toCalc)) {
//
//        }

        return "$fuel"
    }

//    private fun onlyOreReactionsLeft(oreConsumers: Map<String, Reaction>, toCalc: Set<Reaction>): Boolean {
//        toCalc.filter { oreConsumers.containsKey(it.) }
//    }


    fun solve2(scanner: Scanner): String {
        val totality = createReactionMap(scanner)
        val oreConsumers = mutableMapOf<String, Long>()
        val currentAmounts = mutableMapOf<String, Long>()

        val toVisit = mutableSetOf<Reaction>()
        toVisit.addAll(totality.reactionMap.values)

        totality.fuelYielder.reactants.forEach { reactant ->
            if (totality.oreConsumers.containsKey(reactant.name)) {
                oreConsumers.merge(reactant.name, reactant.amount) { t: Long, u: Long -> t + u }
            } else {
                currentAmounts.merge(reactant.name, reactant.amount) { t: Long, u: Long -> t + u }
            }
        }

        while (toVisit.isNotEmpty()) {
            currentAmounts.forEach { it ->
                val reaction = totality.reactionMap[it.key]!!
                reaction.reactants.forEach { reactant ->
                }
            }
        }


        val result = amountOfOreConsumers.map { calcOne(it.value, totality.reactionMap[it.key]!!) }.sum()

        return "$result"
    }

    private fun traceWRT(totality: Totality, reactant: Reactant, amount: Long = 1L) {

    }


    private fun trace(totality: Totality, reactant: Reactant, amount: Long = 1L) {
        val l = reactant.amount * amount
//        val l = (l * reaction.reactants[0].amount) / reaction.yield.amount
        if (totality.oreConsumers.containsKey(reactant.name)) {
            // we've reached an ore consumer, yay
            amountOfOreConsumers.merge(reactant.name, l) { t: Long, u: Long -> t + u }
            println("Adding $l amount of ${reactant.name}, resulting value is ${amountOfOreConsumers[reactant.name]}")
        } else {
            // trace backwards to find more
            println("Tracing $l amount of ${reactant.name}")
            val reaction = totality.reactionMap[reactant.name]!!
            reaction.reactants.forEach {
                trace(totality, it, l / reaction.yield.amount)
            }
        }
    }

    private fun calcOne(numToRound: Long, reaction: Reaction): Long {
//        val divisor = reaction.yield.amount / reaction.reactants[0].amount
        val multiple = reaction.yield.amount // divisor
        val l = (numToRound + (multiple - 1)) / multiple * multiple

//        return (l * reaction.yield.amount) / reaction.reactants[0].amount
        return (l * reaction.reactants[0].amount) / reaction.yield.amount
    }
//            (currentAmount / reaction.yield.amount + 1L) * reaction.yield.amount
//            currentAmount + reaction.yield.amount - (currentAmount % reaction.yield.amount)

    private fun traceReactants(totality: Totality, reaction: Reaction, amount: Long) {
//        println("$reaction $amount")
        if (totality.oreConsumers.containsKey(reaction.yield.name)) {
            val l = amountOfOreConsumers[reaction.yield.name]!! + amount //reaction.yield.amount.toLong()
////            println("Setting ${reaction.yield.name} to $l")
            amountOfOreConsumers[reaction.yield.name] = l //* amount
        } else {
            reaction.reactants.forEach { reactant ->
                val reaction1 = totality.reactionMap[reactant.name]
                if (reaction1 == null) {
                    throw IllegalStateException("${reactant.name} does not map to a reaction")
                }
                traceReactants(totality, reaction1, reactant.amount.toLong() * amount)
            }
        }
    }

    private fun createReactionMap(scanner: Scanner): Totality {
        val reactionMap = mutableMapOf<String, Reaction>()
        var fuelYielder: Reaction = Reaction(listOf(), Reactant(-1, "foo"))
        val oreConsumers = mutableMapOf<String, Reaction>()

        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val split = line.split("=>").map { it.trim() }.filterNot { it.isBlank() }
            val split1: List<String> = split[1].split(" ")
            val `yield` = Reactant(split1[0].toLong(), split1[1])
            val starting = split[0].split(", ")
            val reactants = starting.map { it.split(" ") }.map { Reactant(it[0].toLong(), it[1]) }
            val reaction = Reaction(reactants, `yield`)
            reactionMap[`yield`.name] = reaction
            if (`yield`.name.equals("FUEL")) {
                fuelYielder = reaction
            }

            if (reactants[0].name.equals("ORE")) {
                oreConsumers[`yield`.name] = reaction
            }
        }
        return Totality(reactionMap = reactionMap, fuelYielder = fuelYielder, oreConsumers = oreConsumers)
    }

    data class Totality(val reactionMap: Map<String, Reaction>, val fuelYielder: Reaction, val oreConsumers: Map<String, Reaction>)
    data class Reaction(val reactants: List<Reactant>, val yield: Reactant)
    data class Reactant(val amount: Long, val name: String)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec14().solve(scanner))
}