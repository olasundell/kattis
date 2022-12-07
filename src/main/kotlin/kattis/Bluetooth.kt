package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Bluetooth {
    fun solve(scanner: Scanner): String {
        scanner.nextLine()
        var jaw = Companion.defaultJaw()


        while (scanner.hasNextLine()) {
            val s = scanner.nextLine()
            val t = s.split(" ")[0]
            val c = s.split(" ")[1][0]

            jaw += (t to conv(c))
        }

        return if (jaw.canChewLeft()) {
            "0"
        } else if (jaw.canChewRight()) {
            "1"
        } else {
            "2"
        }
    }

    private fun conv(c: Char): Toothy {
        return when (c) {
            'b' -> Toothy.BLUE
            'm' -> Toothy.MISSING
            else -> Toothy.AWRIGHT
        }
    }

    data class Jaw(val teeth: Map<String, Toothy>) {
        operator fun plus(pair: Pair<String, Toothy>): Jaw = Jaw(teeth + pair)

        fun isRightSideBlue(): Boolean {
            return (1..8).flatMap { listOf(teeth["$it+"], teeth["$it-"]) }.any { it == Toothy.BLUE }
        }

        fun isLeftSideBlue(): Boolean {
            return (1..8).flatMap { listOf(teeth["+$it"], teeth["-$it"]) }.any { it == Toothy.BLUE }
        }

        fun canChewRight(): Boolean {
            return !isRightSideBlue() &&
                    (1..8).map { teeth["$it-"] }.any { it == Toothy.AWRIGHT } &&
                    (1..8).map { teeth["$it+"] }.any { it == Toothy.AWRIGHT }
        }

        fun canChewLeft(): Boolean {
            return !isLeftSideBlue() &&
                    (1..8).map { teeth["-$it"] }.any { it == Toothy.AWRIGHT } &&
                    (1..8).map { teeth["+$it"] }.any { it == Toothy.AWRIGHT }
        }
    }

    companion object {
        fun defaultJaw(): Jaw {
            val teeth = mutableMapOf<String, Toothy>()
            (1..8).forEach {
                teeth["$it-"] = Toothy.AWRIGHT
                teeth["-$it"] = Toothy.AWRIGHT
                teeth["$it+"] = Toothy.AWRIGHT
                teeth["+$it"] = Toothy.AWRIGHT
            }

            return Jaw(teeth)
        }
    }

    enum class Toothy {
        AWRIGHT,
        BLUE,
        MISSING
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Bluetooth().solve(scanner))
}