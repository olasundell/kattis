package kattis

import java.time.Month
import java.time.Month.*
import java.time.MonthDay
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoField
import java.time.temporal.TemporalAccessor
import java.util.*

/**
 * TODO write documentation
 */
//fun range(m1: Month, d1: Int, m2: Month, d2: Int): ClosedRange<MonthDay> = MonthDay.of(m1, d1).rangeTo(MonthDay.of(m2, d2))
//fun range(m1: Month, d1: Int, m2: Month, d2: Int): ClosedRange<MonthDay> = MonthDay.of(m1, d1)..MonthDay.of(m2, d2)
fun range(m1: Month, d1: Int, m2: Month, d2: Int): ClosedRange<MonthDay> = MonthDay.of(m1, d1)..MonthDay.of(m2, d2)

enum class Sign(val range: ClosedRange<MonthDay>) {
    Aries(range(MARCH, 21, APRIL, 20)),
    Taurus(range(APRIL, 21, MAY, 20)),
    Gemini(range(MAY, 21, JUNE, 21)),
    Cancer(range(JUNE, 22, JULY, 22)),
    Leo(range(JULY, 23, AUGUST, 22)),
    Virgo(range(AUGUST, 23, SEPTEMBER, 21)),
    Libra(range(SEPTEMBER, 22, OCTOBER, 22)),
    Scorpio(range(OCTOBER, 23, NOVEMBER, 22)),
    Sagittarius(range(NOVEMBER, 23, DECEMBER, 21)),
    Capricorn(range(DECEMBER, 22, DECEMBER, 31)),
    Capricorn2(range(JANUARY, 1, JANUARY, 20)),
    Aquarius(range(JANUARY, 21, FEBRUARY, 19)),
    Pisces(range(FEBRUARY, 20, MARCH, 20))
}

class AstrologicalSign {
    fun solve(scanner: Scanner): String {
        val result = mutableListOf<Sign>()

        scanner.nextLine()

        while (scanner.hasNext()) {
            val line = scanner.nextLine()

            val f = DateTimeFormatter.ofPattern("d LLL")
            val d2: TemporalAccessor = f.parse(line)
//            val d = LocalDate.parse("2020 ${line}", f)

            val m = d2.get(ChronoField.MONTH_OF_YEAR)
            val d = d2.get(ChronoField.DAY_OF_MONTH)
            val md = MonthDay.of(m, d)

            result.add(find(md))
        }

        return result.map {
            if (it == Sign.Capricorn2) {
                Sign.Capricorn
            } else {
                it
            }
        }.map { it.name }.joinToString(separator = "\n")
    }

    private fun find(md: MonthDay): Sign {
        return Sign.values().find { it.range.contains(md) }!!
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(AstrologicalSign().solve(scanner))
}