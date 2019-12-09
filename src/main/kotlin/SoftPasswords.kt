import java.util.Scanner;

/**
 * TODO write documentation
 */
class SoftPasswords {
    fun solve(scanner: Scanner): String {
        val s = scanner.next()
        val p = scanner.next()

        return if (check(s, p)) {
            "Yes"
        } else {
            "No"
        }
    }

    /*
        P and S are identical;
        S can be formed from P by prepending a single digit (0–9);
        S can be formed from P by appending a single digit;
        S is equal to P after reversing the case of all letters in P;
     */
    private fun check(s: String, p: String): Boolean {
        val prepend = Regex("[0-9]$p").matches(s)
        val append = Regex("$p[0-9]").matches(s)
        val reverseCase = s.map { if (it.isUpperCase()) it.toLowerCase() else it.toUpperCase() }.joinToString(separator = "")

        return (s == p) || (reverseCase == p) || prepend || append
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(SoftPasswords().solve(scanner))
}