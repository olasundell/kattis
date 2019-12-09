import java.util.Scanner;

/**
 * TODO write documentation
 */
class Relocation {
    fun solve(scanner: Scanner): String {
        val noOfCompanies = scanner.nextInt()
        val noOfRequests = scanner.nextInt()

        val companies = (1..noOfCompanies).map {
            it to scanner.nextInt()
        }.toMap().toMutableMap()

        val response = mutableListOf<Int>()

        for (i in 1..noOfRequests) {
            val operand = scanner.nextInt()
            if (operand == 1) {
                val c = scanner.nextInt()
                val d = scanner.nextInt()
                companies[c] = d
            } else {
                val c1 = scanner.nextInt()
                val c2 = scanner.nextInt()
                response.add(Math.abs(companies[c1]!! - companies[c2]!!))
            }
        }

        return response.joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Relocation().solve(scanner))
}