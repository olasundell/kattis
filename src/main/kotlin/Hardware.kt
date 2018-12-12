import java.util.Scanner;
import java.util.function.BiFunction

/**
 * TODO write documentation
 */
class Hardware {
    fun solve(scanner: Scanner): String {
        val noOfOrders = scanner.nextInt()
        scanner.nextLine()
        val lines = mutableListOf<String>()
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine())
        }

        val orders = mutableListOf<Order>()
        for (x in 0 until noOfOrders) {
            orders.add(processOrder(lines))
        }
        return orders.map(Order::toString).joinToString(separator = "\n")
    }

    private fun processOrder(lines: MutableList<String>): Hardware.Order {
        val street = lines.removeAt(0)
        val addresses = lines.removeAt(0)
        val numbers = mutableListOf<Int>()

        while (lines.isNotEmpty() && (lines[0][0] == '+' || lines[0][0].isDigit())) {
            val line = lines.removeAt(0)
            numbers.addAll(handleLine(line))
        }

        return Order(street, addresses, numbers)
    }

    private fun handleLine(line: String): Collection<Int> {
        if (line[0] == '+') {
            return multipleNumbers(line)
        } else {
            return listOf(line.toInt())
        }
    }

    private fun multipleNumbers(line: String): Collection<Int> {
        val split = line.split(" ")
        val first = split[1].toInt()
        val last = split[2].toInt()
        val st = split[3].toInt()
        val list = mutableListOf<Int>()

        for (i in first..last step st) {
            list.add(i)
        }

        return list
    }

    data class Order(val street: String, val addresses: String, val numbers: List<Int>) {
        override fun toString(): String {
            return street + "\n" + addresses + "\n" + digits(numbers)
        }

        private fun digits(numbers: List<Int>): String {
            val map = mutableMapOf<Char, Int>()

            for (c in '0'..'9') {
                map.put(c, 0)
            }

            numbers.forEach { n -> n.toString().forEach { c -> map.computeIfPresent(c, { t, u -> u + 1 }) }}

            return map.toSortedMap().map { entry ->  "Make ${entry.value} digit ${entry.key}" }.joinToString(separator = "\n") +
                    "\nIn total ${map.values.sum()} digit" + if (map.values.sum() > 1) { "s" } else { "" }
        }
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Hardware().solve(scanner))
}