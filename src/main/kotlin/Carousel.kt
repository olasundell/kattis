import java.util.Scanner;

/**
 * TODO write documentation
 */
class Carousel {
    fun solve(scanner: Scanner): String {
        var num = scanner.nextInt()
        var max = scanner.nextInt()
        val results = mutableListOf<String>()

        while (num != 0 && max != 0) {
            val offers = mutableListOf<Offer>()
            for (i in 0 until num) {
                val n = scanner.nextInt()
                val p = scanner.nextInt()

                if (n <= max) {
                    offers.add(Offer(n, p))
                }
            }


            if (offers.isEmpty()) {
                results.add("No suitable tickets offered")

            } else {
                offers.sort()
                results.add(offers[0].toString())
            }
            offers.clear()
            num = scanner.nextInt()
            max = scanner.nextInt()
        }

        return results.joinToString(separator = "\n")
    }
}

data class Offer(val tickets: Int, val price: Int) : Comparable<Offer> {
    override fun compareTo(other: Offer): Int {
        return if (other.ratio() == this.ratio()) {
            other.tickets - this.tickets;
        } else {
            (20.0 * (other.ratio() - this.ratio())).toInt()
        }
    }

    override fun toString(): String {
        return "Buy $tickets tickets for $$price"
    }

    private fun ratio(): Double {
        return tickets.toDouble() / price.toDouble()
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Carousel().solve(scanner))
}