import kattis.AlphabetAnimals
import util.AbstractKotlinTest

import org.junit.Test

/**
 * TODO write documentation
 */
class AlphabetAnimalsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, AlphabetAnimals()::solve)
    }

    @Test
    fun two() {
        runTest(2, AlphabetAnimals()::solve)
    }

    @Test
    fun three() {
        runTest(3, AlphabetAnimals()::solve)
    }

    @Test
    fun four() {
        runTest(4, AlphabetAnimals()::solve)
    }

    @Test
    fun five() {
        runTest(5, AlphabetAnimals()::solve)
    }
}