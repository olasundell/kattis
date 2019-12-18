package kattis

import java.util.*

/**
 * TODO write documentation
 */
class HToo {
    fun solve(scanner: Scanner): String {
        val storedMolecule = scanner.next()
        val n = scanner.nextInt()
        val targetMolecule = scanner.next()

        val supplies = parseMolecule(storedMolecule).mapValues { it.value * n }

        return iterations(targetMolecule, supplies).toString()
    }

    fun parseMolecule(m: String): Map<Char, Int> {
        val map = mutableMapOf<Char, Int>()

        val regexp = Regex("""(\p{Upper})(\d*)""")
        var result = regexp.find(m)

        while (result != null) {
            val (atom, num) = result!!.destructured
            val n = if (num == "") {
                1
            } else {
                num.toInt()
            }
            map.compute(atom[0]) { t: Char, u: Int? -> u?.plus(n) ?: n }
            result = result.next()
        }

        return map
    }

    fun iterations(m: String, supplies: Map<Char, Int>): Int {
        val map = parseMolecule(m)

        return map.map { supplies[it.key]?.div(it.value) ?: 0 }.sorted()[0]
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(HToo().solve(scanner))
}
