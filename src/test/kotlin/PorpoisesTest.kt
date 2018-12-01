import org.junit.Assert
import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PorpoisesTest: AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Porpoises()::solve)
    }

    @Test
    fun calcAt() {
        val p = Porpoises()
//        p.calcAt(60)
//        for (i in 61..100) {
//            println("$i ${p.calcAt(i.toLong())}")
//        }
//        Assert.assertEquals(1, Porpoises().calcAt(2))
//        Assert.assertEquals(21, Porpoises().calcAt(8))
//        Assert.assertEquals(0, Porpoises().calcAt(4500))
        Assert.assertEquals(836311903, Porpoises().calcAt(46))
    }

    @Test
    fun findMax() {
        var i: Long = 1
        while (true) {
            if (Porpoises().calcAt(i) >= 1_000_000_000) {
                print(i - 1)
                break;
            } else {
                i++
            }
        }
    }

    @Test
    fun findRepeat() {
        var prev: Long = 0
        var sum : Long = 1
        var found = mutableSetOf<Long>()
        var prevFound = false

        for (i in 1 until 1_000_000_000) {
            val newSum = (sum + prev) % 1_000_000_000
            prev = sum
            sum = newSum

//            if (sum == 0L) {
//                println(i)
//                break;
//            }

            if (found.contains(sum)) {
                if (prevFound) {
                    println(i)
                    break;
                } else {
                    prevFound = true
                }
            } else {
                prevFound = false
            }

            found.add(sum)
        }
    }
}