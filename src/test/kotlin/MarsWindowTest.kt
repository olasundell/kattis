import org.junit.Assert
import org.junit.Assert.*
import org.junit.Test
import util.AbstractKotlinTest
import java.time.LocalDate
import java.util.*

/**
 * TODO write documentation
 */
class MarsWindowTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, MarsWindow()::solve)
    }

    @Test
    fun two() {
        runTest(2, MarsWindow()::solve)
    }

    @Test
    fun three() {
        runTest(3, MarsWindow()::solve)
    }

    @Test
    fun four() {
        runTest(4, MarsWindow()::solve)
    }

    @Test
    fun specific() {
        val marsWindow = MarsWindow()
        Assert.assertEquals("2026 should work", "yes", marsWindow.solve(Scanner("2026")))
    }

    @Test
    fun manual() {
        var d = LocalDate.of(2018, 4, 1)
        val years = mutableSetOf(2018)

        while (d.year <= 10_000) {
            d = d.plusMonths(26)
//            System.out.println("""${d.year} ${d.month}""")
            years.add(d.year)
        }

        val marsWindow = MarsWindow()

        for (i in 2018..10_000) {
            val expected = if (years.contains(i)) {
                "yes"
            } else {
                "no"
            }

            Assert.assertEquals(i.toString(), expected, marsWindow.solve(Scanner(i.toString())))
        }
    }
}