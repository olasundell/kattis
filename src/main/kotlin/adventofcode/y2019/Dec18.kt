package adventofcode.y2019;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class Dec18 {
    fun solve(scanner: Scanner): String {
        val lines = mutableListOf<List<Char>>()
        while (scanner.hasNextLine()) {
//            lines.add(scanner.nextLine().chunked(1))
            lines.add(scanner.nextLine().toCharArray().toList())
        }

//        val lower = "a-z".toRegex()
//        val upper = "A-Z".toRegex()

        var cp = Pos(-1, -1)
        val doors = mutableMapOf<Char, Pos>()
        val keys = mutableMapOf<Char, Pos>()

        for (y in lines.indices) {
            for (x in lines[y].indices) {
                when (lines[y][x]) {
                    '@' -> cp = Pos(x, y)
                    in 'a'..'z' -> keys[lines[y][x]] = Pos(x, y)
                    in 'A'..'Z' -> doors[lines[y][x]] = Pos(x, y)
                }
            }
        }

//    });


        return ""
    }

//    data class Key(val x: Int, val y: Int, val unlocks: Char)
//    data class Door(val x: Int, val y: Int, val id: Char)
//    data class Floor(val x: Int, val y: Int)
    data class Pos(val x: Int, val y: Int)
}

class Tedis {
    fun get(key: String): String? = null
}

class Json {
    fun parse(doc: Any?): String = ""
}

fun foo(redisKey: String) {
    val tedis = Tedis()
    val JSON = Json()

    val doc = JSON.parse(tedis.get(redisKey))

//    if (doc && typeof doc === "string") {
//        val result: string = JSON.parse(doc);
//        if (result) {
//            res.send(result);
//        } else {
//            res.status(404).send("Not found");
//        }
//    } else {
//        res.status(404).send("Not found");
//    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec18().solve(scanner))
}