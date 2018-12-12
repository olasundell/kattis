import java.util.*

class IsItHalloween {
    fun solve(scanner: Scanner): String {
        val line = scanner.nextLine()

        if (line.equals("OCT 31") || line.equals("DEC 25")) {
            return "yup"
        } else {
            return "nope"
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(IsItHalloween().solve(scanner))
}