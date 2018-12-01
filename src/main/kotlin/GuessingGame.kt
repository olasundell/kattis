import java.util.Scanner;

/**
 * TODO write documentation
 */
class GuessingGame {
    fun solve(scanner: Scanner): String {
        val results = mutableListOf<Result>()
        var guess = scanner.nextInt()
        var low = 1
        var high = 10

        while (guess != 0) {
            scanner.nextLine()
            val result = scanner.nextLine()
            when (result) {
                "right on" -> {
                    if (guess in low..high) {
                        results.add(Result.MAYBE_HONEST)
                    } else {
                        results.add(Result.DISHONEST)
                    }

                    high = 10
                    low = 1
                }
                "too high" -> high = Math.min(high, guess - 1)
                else -> low = Math.max(low, guess + 1)
            }

            guess = scanner.nextInt()
        }
        return results.joinToString("\n")
    }

    enum class Result(val text: String) {
        MAYBE_HONEST("Stan may be honest"),
        DISHONEST("Stan is dishonest");

        override fun toString(): String{
            return text
        }

    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(GuessingGame().solve(scanner))
}