package kattis;

import java.util.Scanner;

/**
 * TODO write documentation
 */
class DamagedEquation {
    fun solve(scanner: Scanner): String {
        val l = scanner.nextLine().split(" ").map { it.toInt() }
        val s = mutableListOf<String>()

        val left = listOf(
            Add(l[0], l[1]),
            Sub(l[0], l[1]),
            Mul(l[0], l[1]),
            Div(l[0], l[1])
        )

        val right = listOf(
            Add(l[2], l[3]),
            Sub(l[2], l[3]),
            Mul(l[2], l[3]),
            Div(l[2], l[3])
        )

        (0..3).forEach { i ->
            (0..3).forEach { j ->
                if (left[i] == right[j]) {
                    s.add(left[i].toString() + " = " + right[j].toString())
                }
            }
        }

//        if (l[0] + l[1] == l[2] + l[3]) {
//            s += "${l[0]} + ${l[1]} = ${l[2]} + ${l[3]}"
//        } else if (l[0] - l[1] == l[2] - l[3]) {
//            s += "${l[0]} - ${l[1]} = ${l[2]} - ${l[3]}"
//        } else if (l[0] * l[1] == l[2] * l[3]) {
//            s += "${l[0]} * ${l[1]} = ${l[2]} * ${l[3]}"
//        } else if (l[0] / l[1] == l[2] / l[3]) {
//            s += "${l[0]} / ${l[1]} = ${l[2]} / ${l[3]}"
//        }


        return if (s.isEmpty()) {
            "problems ahead"
        } else {
            s.sorted().joinToString(separator = "\n")
        }
    }

    abstract class Op(val a: Int, val b: Int) {
        abstract fun exec(): Int
        override fun equals(other: Any?): Boolean = other is Op && other.exec() == this.exec()
        override fun hashCode(): Int = super.hashCode()
    }

    class Add(a: Int, b: Int) : Op(a, b) {
        override fun exec(): Int = a + b
        override fun toString(): String = "$a + $b"
    }

    class Sub(a: Int, b: Int) : Op(a, b) {
        override fun exec(): Int = a - b
        override fun toString(): String = "$a - $b"
    }

    class Mul(a: Int, b: Int) : Op(a, b) {
        override fun exec(): Int = a * b
        override fun toString(): String = "$a * $b"
    }

    class Div(a: Int, b: Int) : Op(a, b) {
        override fun exec(): Int = if (b == 0) {
            Int.MAX_VALUE
        } else {
            Math.floorDiv(a, b)
        }

        override fun toString(): String = "$a / $b"
    }
}

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(DamagedEquation().solve(scanner))
}