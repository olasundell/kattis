import java.util.Scanner;

/**
 * TODO write documentation
 */
class ToLower {
    fun solve(scanner: Scanner): String {
        val numberOfTests = scanner.nextInt()
        val numberOfStringsPerTest = scanner.nextInt()
        scanner.nextLine()
        var successes = 0

        for (i in 1..numberOfTests) {
            var success = true
            for (j in 1..numberOfStringsPerTest) {
                val line = scanner.nextLine()
                val iterator = line.toCharArray().iterator()
                iterator.nextChar()

                while (iterator.hasNext()) {
                    if (iterator.nextChar().isUpperCase()) {
                        success = false
                    }
                }
            }

            if (success) {
                successes++
            }
        }

        return successes.toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(ToLower().solve(scanner))
}