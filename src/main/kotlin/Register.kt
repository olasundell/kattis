import java.util.Scanner;

/**
 * TODO write documentation
 */
class Register {
    fun solve(scanner: Scanner): String {
        val list = mutableListOf<Int>()

        list.add(scanner.nextInt())
        list.add(scanner.nextInt() * 2)
        list.add(scanner.nextInt() * 2 * 3)
        list.add(scanner.nextInt() * 2 * 3 * 5)
        list.add(scanner.nextInt() * 2 * 3 * 5 * 7)
        list.add(scanner.nextInt() * 2 * 3 * 5 * 7 * 11)
        list.add(scanner.nextInt() * 2 * 3 * 5 * 7 * 11 * 13)
        list.add(scanner.nextInt() * 2 * 3 * 5 * 7 * 11 * 13 * 17)

        val max = 2 * 3 * 5 * 7 * 11 * 13 * 17 * 19 - 1

        return (max - list.sum()).toString()
    }
}

// 2
//, 3
//, 5
//, 7
//, 11
//, 13
//, 17
//, 19
//.
fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Register().solve(scanner))
}