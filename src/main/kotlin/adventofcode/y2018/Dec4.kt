package adventofcode.y2018;

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

class Dec4 {
    fun solve(scanner: Scanner): String {
        val list = readGuards(scanner).sortedByDescending { g -> g.second.totalSleep }
        val guard = list[0].second
        return (guard.mostMinute().first * guard.id).toString()
    }

    fun solve2(scanner: Scanner): String {
        val list = readGuards(scanner).sortedByDescending { g -> g.second.mostMinute().second }
        val guard = list[0].second

        return (guard.mostMinute().first * guard.id).toString()
    }

    private fun readGuards(scanner: Scanner): List<Pair<Int, Guard>> {
        val guards = mutableMapOf<Int, Guard>()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        var currentGuard: Guard = Guard(-1)
        var startsSleeping = -1

        while (scanner.hasNext()) {
            val line = scanner.nextLine()
            if (line.contains("#")) {
                val id = line.split("#")[1].split(" ")[0].toInt()
                currentGuard = guards.computeIfAbsent(id) { i -> Guard(i) }
            } else {
                val dateTime = LocalDateTime.parse(line.substring(1, 17), formatter)
                val action = line.split("] ")[1]
                when (action) {
                    "falls asleep" -> startsSleeping = dateTime.minute
                    "wakes up" -> currentGuard.sleep(startsSleeping, dateTime.minute)
                }
            }
        }

        return guards.toList()
    }

    class Guard(val id: Int) {
        // empty init, there might be a guard which doesn't sleep at all. 0 sleep at minute 0 is still true.
        private val sleepTimes: MutableMap<Int, Int> = mutableMapOf(Pair(0, 0))
        var totalSleep = 0

        fun sleep(start: Int, wakeUp: Int) {
            for (i in start until wakeUp) {
                sleepTimes.compute(i) { _, u -> u?.plus(1) ?: 1 }
                totalSleep++
            }
        }

        fun mostMinute(): Pair<Int, Int> = sleepTimes.toList().sortedByDescending { m -> m.second }[0]
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec4().solve(scanner))
}