import java.util.Scanner;

/**
 * TODO write documentation
 */
class Patuljci {
    fun solve(scanner: Scanner): String {
        val ints = mutableListOf<Int>()
        for (i in 1..9) {
            ints.add(scanner.nextInt())
        }

        for (i in 0..7) {
            for (j in i + 1 .. 8) {
                val list = ints.toMutableList()
                list.removeAt(j)
                list.removeAt(i)

                if (list.sum() == 100) {
                    return list.joinToString(separator = "\n")
                }
            }
        }
        return ""
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Patuljci().solve(scanner))
}