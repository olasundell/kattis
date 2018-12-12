import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.time.temporal.TemporalUnit
import java.util.Scanner;

/**
 * TODO write documentation
 */
class Natrij {
    fun solve(scanner: Scanner): String {
        val now = localTime(scanner)
        val then = localTime(scanner)

        if (now == then) {
            return "24:00:00"
        }

        val diff = then.minusHours(now.hour.toLong()).minusMinutes(now.minute.toLong()).minusSeconds(now.second.toLong())

        return diff.format(DateTimeFormatter.ISO_TIME)
    }

    private fun localTime(scanner: Scanner): LocalTime {
        val line = scanner.nextLine().split(":")

        return LocalTime.of(line[0].toInt(), line[1].toInt(), line[2].toInt())
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Natrij().solve(scanner))
}