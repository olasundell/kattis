package adventofcode.y2020;

/**
 * TODO write documentation
 */
class Dec15() {
    fun solve(line: String): Int {
        val numbers = line.split(",").map { it.toInt() }
        val map = mutableMapOf<Int, Speak>()
        var curr = numbers.last()

        numbers.forEachIndexed { index, i -> map[i] = Speak(index + 1) }

        ((numbers.size + 1)..30000000).forEach { turn ->
            curr = map[curr]?.wasSpoken() ?: 0
//            println(curr)

            if (map.containsKey(curr)) {
                map[curr] = map[curr]!!.spake(turn)
            } else {
                map[curr] = Speak(turn)
            }
        }

        return curr
    }

    data class Speak(val first: Int, val second: Int = -1)

    fun Speak.spake(turn: Int): Speak = Speak(turn, this.first)
    fun Speak.wasSpoken(): Int = if (second == -1) 0 else first - second
}
