import java.util.*

class ShatteredCake {
    fun solve(scanner: Scanner): String {
        val width = scanner.nextInt()
        val n = scanner.nextInt()
        var area = 0

        for (i in 0 until n) {
            area += scanner.nextInt() * scanner.nextInt()
        }

        return (area / width).toInt().toString()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(ShatteredCake().solve(scanner))
}