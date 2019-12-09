import java.util.Scanner;

/**
 * TODO write documentation
 */
class PrincessPeach {
    fun solve(scanner: Scanner): String {
        val noOfObstacles = scanner.nextInt()
        val noOfFoundObstacles = scanner.nextInt()

        val foundObstacles = (1..noOfFoundObstacles).map {
            scanner.nextInt()
        }.toSet()

        val result = mutableListOf<String>()
        for (i in 0 until noOfObstacles) {
            if (!foundObstacles.contains(i)) {
                result.add(i.toString())
            }
        }

        result.add("Mario got ${foundObstacles.size} of the dangerous obstacles.")

        return result.joinToString(separator = "\n")
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(PrincessPeach().solve(scanner))
}