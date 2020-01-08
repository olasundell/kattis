import kattis.KattissQuest
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test
import java.io.File
import kotlin.random.Random

/**
 * TODO write documentation
 */
class KattissQuestTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, KattissQuest()::solve)
    }

//    @Test
    fun two() {
        runTest(2, KattissQuest()::solve)
    }

    @Test
    fun three() {
        runTest(3, KattissQuest()::solve)
    }

    @Test
    fun four() {
        runTest(4, KattissQuest()::solve)
    }

    @Test
    fun five() {
        runTest(5, KattissQuest()::solve)
    }

    //    @Test
    fun writeToFile() {
        val writer = File("src/test/resources/kattissquest/2.in").writer()

        writer.write("200000\n")
        repeat (200_000) {
            writer.write(randomCmd() + "\n")
        }

        writer.close()
    }

    private fun randomCmd(): String {
        return if (Random.Default.nextInt(4) == 0) {
            "query ${Random.Default.nextInt(1_000) + 1}"
        } else {
            "add ${Random.Default.nextInt(1_000) + 1} ${Random.Default.nextInt(1_000) + 1}"
        }
    }
}