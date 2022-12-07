package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class EventPlanning {
    fun solve(scanner: Scanner): String {
        val participants = scanner.nextInt()
        val budget = scanner.nextInt()
        val noOfHotels = scanner.nextInt()
        val weeks = scanner.nextInt()

        scanner.nextLine()

        val hotels = (0 until noOfHotels).map { readHotel(scanner.nextLine(), scanner.nextLine()) }.sortedBy { it.price }

        var minPrice = Int.MAX_VALUE

        for (i in 0 until weeks) {
            if (hotels.map { it.availableRooms[i] }.sum() < participants) {
                continue
            }

            for (j in hotels.indices) {
                if (participants <= hotels[j].availableRooms[i]) {
                    minPrice = (hotels[j].price * participants).coerceAtMost(minPrice)
                    break
                }
            }
        }

        return if (minPrice == Int.MAX_VALUE || budget < minPrice) {
            "stay home"
        } else {
            minPrice.toString()
        }
    }

    private fun readHotel(price: String, availability: String): Hotel {
        return Hotel(price.toInt(), availability.split(" ").map { it.toInt() })
    }

    data class Hotel(val price: Int, val availableRooms: List<Int>)
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(EventPlanning().solve(scanner))
}