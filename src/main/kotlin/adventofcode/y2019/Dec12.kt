package adventofcode.y2019

import java.util.*

/**
 * TODO write documentation
 */
class Dec12 {
    val zeroVel = Tri(0, 0, 0)
    val moons = mutableListOf<Moon>()
//    val states = mutableListOf<List<Moon>>()
    val stateHash = mutableMapOf<Long, Long>()
    val maxMap = mutableMapOf<String, Short>()
    val minMap = mutableMapOf<String, Short>()
    val keys = listOf("px", "py", "pz", "vx", "vy", "vz")

    fun solve(scanner: Scanner): String {
        val lines = listOf(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine())
//        277068010964808
//        277068010964808
//        277068010964808
        val part2 = Day12Kotlin(lines).part2()
        return "$part2"
    }

    fun foo2(scanner: Scanner): String {
        val lines = (1..4).map { scanner.nextLine() }
        val m = createMoons(lines)
        val x = mutableListOf<Axis>()
        val y = mutableListOf<Axis>()
        val z = mutableListOf<Axis>()

        (0..3).forEach {
            x.add(Axis(m[it].pos.x, m[it].vel.x))
            y.add(Axis(m[it].pos.y, m[it].vel.y))
            z.add(Axis(m[it].pos.z, m[it].vel.z))
        }

        val xC = calcOne(x)
        val yC = calcOne(y)
        val zC = calcOne(z)

        return "${lcm(listOf(xC, yC, zC))}"
    }

    private fun gcd(aP: Long, bP: Long): Long {
        var a = aP
        var b = bP
        while (b > 0) {
            val temp = b
            b = a % b // % is remainder
            a = temp
        }
        return a
    }

    private fun gcd(input: LongArray): Long {
        var result = input[0]
        for (i in 1 until input.size) {
            result = gcd(result, input[i])
        }
        return result
    }

    private fun lcm(a: Long, b: Long): Long = a * (b / gcd(a, b))

    private fun lcm(input: List<Long>): Long {
        var result = input[0]
        for (i in 1 until input.size) {
            result = lcm(result, input[i])
        }
        return result
    }

    private fun calcOne(x: MutableList<Axis>): Long {
        val hash = mutableSetOf<List<Axis>>(x)

        var i = 0L

        while (true) {
            i++
            for (i in 0 until 4) {
                for (j in i + 1 until 4) {
                    val firstDelta = oneAxisDelta(x[i].pos, x[j].pos)
                    val secondDelta = oneAxisDelta(x[j].pos, x[i].pos)

                    x[i] = x[i].deltaOnVel(firstDelta)
                    x[j] = x[j].deltaOnVel(secondDelta)
    //                    val m = calcRelativeVelocities(x[i], newList[j])

                }
            }

            val r = x.map { Axis(it.pos + it.vel, it.vel) }
            if (hash.contains(r)) {
                return i
            } else {
                hash.add(r)
            }
            x.clear()
            x.addAll(r)
        }
    }

    data class Axis(val pos: Int, val vel: Int) {
        fun deltaOnVel(delta: Int): Axis = Axis(pos, vel + delta)

        constructor(pos: Short, vel: Short) : this(pos.toInt(), vel.toInt())
//        fun hash(): Int = pos.shl(16) + vel
    }

    fun foo(scanner: Scanner): String {
        val lines = (1..4).map { scanner.nextLine() }
        val m = createMoons(lines)
        var t = m
        var c = 0L
        do {
            t = iterateMoons(t)
            c++
            if (c % 1_000_000L == 0L) {
                println("$c")
            }
        } while (!m.equals(t))
            //            states.add(t)
//            stateHash[Moons(m[0], m[1], m[2], m[3]).hashCode()]
//            keys.forEach { maximate(t, it) }
//            keys.forEach { minimate(t, it) }
//            t = iterateMoons(t)
//        }
        moons.clear()
        moons.addAll(t)

//        return "${moons.map { it.energy() }.sum()}"
        return "$c"
    }

    fun createMoons(lines: List<String>): List<Moon> {
        val l = mutableListOf<Moon>()
        repeat(4) {
            l.add(moon(lines[it]))
        }

        return l
    }

    private fun moon(pos: String, vel: String = "<x=0, y=0, z=0>") = Moon(coordFromStr(pos), coordFromStr(vel))

    fun createMoonsWithVelocity(lines: List<String>): List<Moon> {
        val r = """.*?pos=(?<pos><.*?>),[ ]+vel=(?<vel><.*?>).*?""".toRegex()
        return lines.map { line -> r.matchEntire(line) }
                .map { moon(it!!.groups["pos"]!!.value.trim(), it!!.groups["vel"]!!.value.trim()) }
    }

    fun iterate(m: List<Moon>, i: Int): List<Moon> {
        var t = m
        repeat(i) {
//            states.add(t)
//            stateHash[Moons(m[0], m[1], m[2], m[3]).hashCode()]
            keys.forEach { maximate(t, it) }
            keys.forEach { minimate(t, it) }
            t = iterateMoons(t)
        }
//        states.add(t)
        return t
    }

    fun minimate(t: List<Moon>, key: String) {
        minMap[key] = minOf(t.map {
            when (key) {
                "px" -> it.pos.x
                "py" -> it.pos.y
                "pz" -> it.pos.z
                "vx" -> it.vel.x
                "vy" -> it.vel.y
                "vz" -> it.vel.z
                else -> throw IllegalArgumentException("$key isn't valid")
            }
        }.min() ?: 0, minMap[key] ?: 0)
    }

    fun maximate(t: List<Moon>, key: String) {
        maxMap[key] = maxOf(t.map {
            when (key) {
                "px" -> it.pos.x
                "py" -> it.pos.y
                "pz" -> it.pos.z
                "vx" -> it.vel.x
                "vy" -> it.vel.y
                "vz" -> it.vel.z
                else -> throw IllegalArgumentException("$key isn't valid")
            }
        }.max() ?: 0, maxMap[key] ?: 0)
    }
    fun iterateMoons(moons: List<Moon>): List<Moon> {
        val newList = moons.toMutableList()
//        val velocities = moons.map { it.vel }.toMutableList()

        for (i in 0 until 4) {
            for (j in i + 1 until 4) {
                val m = calcRelativeVelocities(newList[i], newList[j])
                newList[i] = m.first
                newList[j] = m.second
            }
        }

        return newList.map { it.move() }
    }

    fun calcRelativeVelocities(first: Moon, second: Moon): Pair<Moon, Moon> {
        val firstDelta = first.pos.delta(second.pos)
        val secondDelta = second.pos.delta(first.pos)

        val firstVel = first.vel + firstDelta
        val secondVel = second.vel + secondDelta

        return Pair(first.withVel(firstVel), second.withVel(secondVel))
    }

    fun coordFromStr(str: String): Tri {
        val nRegex = """[ ]*-?\d+"""
        val regex = """<x=(?<x>$nRegex), y=(?<y>$nRegex), z=(?<z>$nRegex)>""".toRegex()
        val result: MatchResult = regex.matchEntire(str)!!

        return Tri(
                result.groups["x"]!!.value.trim().toShort(),
                result.groups["y"]!!.value.trim().toShort(),
                result.groups["z"]!!.value.trim().toShort()
        )
    }

    data class Moons(val one: Moon, val two: Moon, val three: Moon, val four: Moon)

    data class Moon(val pos: Tri, val vel: Tri = Tri(0, 0, 0)) {
        fun energy(): Int = pos.sum() * vel.sum()
        fun withVel(newVel: Tri) = Moon(this.pos, newVel)
        fun move(): Moon = Moon(pos + vel, vel)
        fun hash(): String = "${pos.x}${pos.y}${pos.z}${vel.x}${vel.y}${vel.z}"
    }

    data class Tri(val x: Short, val y: Short, val z: Short) {
        fun sum(): Int = x.absV() + y.absV() + z.absV()
        fun delta(other: Tri): Tri = Tri(
                oneAxisDelta(x, other.x),
                oneAxisDelta(y, other.y),
                oneAxisDelta(z, other.z)
        )

        operator fun minus(c: Tri): Tri = Tri((x - c.x).toShort(), (y - c.y).toShort(), (z - c.z).toShort())
        operator fun plus(c: Tri): Tri = Tri((x + c.x).toShort(), (y + c.y).toShort(), (z + c.z).toShort())

    }

    companion object {
        fun oneAxisDelta(first: Short, second: Short): Short = if (first > second) -1 else if (second > first) 1 else 0
        fun oneAxisDelta(first: Int, second: Int): Int = if (first > second) -1 else if (second > first) 1 else 0
    }
}

fun Short.absV(): Short = if (this < 0) (-this).toShort() else this

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    System.out.println(Dec12().solve(scanner))
}