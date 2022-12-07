package adventofcode.y2020;

import java.awt.Point
import java.lang.Math.abs
import java.util.*

/**
 * TODO write documentation
 */
class Dec12 {
    fun solve(scanner: Scanner): String {
        var state = State(Point(0, 0), Point(10, -1))
        while (scanner.hasNextLine()) {
            val line = scanner.nextLine()
            val action = line[0]
            val amount = line.substring(1).toInt()

            state = when (action) {
                'R' -> state.turnWp(Turn.R, amount)
                'L' -> state.turnWp(Turn.L, amount)
                'N' -> state.moveWp(Dir.N, amount)
                'E' -> state.moveWp(Dir.E, amount)
                'W' -> state.moveWp(Dir.W, amount)
                'S' -> state.moveWp(Dir.S, amount)
                'F' -> state.move(amount)
                else -> throw IllegalArgumentException("$action $amount is illegal")
            }
            println("$line $state")
        }

        return (abs(state.pos.x) + abs(state.pos.y)).toString()
    }

    // Action N means to move north by the given value.
    //Action S means to move south by the given value.
    //Action E means to move east by the given value.
    //Action W means to move west by the given value.
    //Action L means to turn left the given number of degrees.
    //Action R means to turn right the given number of degrees.
    //Action F means to move forward by the given value in the direction the ship is currently facing.

    data class State(val pos: Point, val wp: Point)

    fun State.turnWp(t: Turn, degrees: Int): State {
        val steps: Int = (degrees / 90)
        var p = this.wp
        for (i in 0 until steps) {
            if (t == Turn.L) {
                p = Point(p.y, -p.x)
            } else {
                p = Point(-p.y, p.x)
            }
        }

        return State(this.pos, p)
    }

    fun State.move(amount: Int): State {
        val x = this.pos.x + this.wp.x * amount
        val y = this.pos.y + this.wp.y * amount

        return State(Point(x, y), this.wp)
    }

    fun State.moveWp(d: Dir, amount: Int): State = State(this.pos, d.translate(this.wp, amount))

    enum class Dir(val point: Point) {
        N(Point(0, -1)), E(Point(1, 0)), S(Point(0, 1)), W(Point(-1, 0));

        fun translate(pos: Point, amount: Int): Point {
            return Point(pos.x + amount * this.point.x, pos.y + amount * this.point.y)
        }
    }

    enum class Turn(val applier: Int) {
        R(1), L(-1)
    }

    fun turn(curDir: Dir, degrees: Int, t: Turn): Dir {
        val steps: Int = (degrees / 90)
        val applied = steps * t.applier
        val amount = applied + 4 * steps

        val newDirIdx = (Dir.values().indexOf(curDir) + amount) % Dir.values().size

        return Dir.values()[newDirIdx]
    }
}


fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec12().solve(scanner))
}