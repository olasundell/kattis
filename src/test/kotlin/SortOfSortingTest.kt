import kattis.SortOfSorting
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class SortOfSortingTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, SortOfSorting()::solve)
    }
}