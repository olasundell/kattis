import kattis.ConquestCampaign
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test
import java.io.File

/**
 * TODO write documentation
 */
class ConquestCampaignTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, ConquestCampaign()::solve)
    }

    @Test
    fun two() {
        runTest(2, ConquestCampaign()::solve)
    }

    @Test
    fun three() {
        runTest(3, ConquestCampaign()::solve)
    }

    @Test
    fun four() {
        runTest(4, ConquestCampaign()::solve)
    }

//    @Test
    fun writeFile() {
        val file = File("/tmp/4.in")
        val writer = file.bufferedWriter()

        writer.append("100 10000 5000")
        writer.newLine()

        for (x in 1..50) {
            for (y in 1..5_000) {
                writer.append("${x * 2} ${y * 2}")
                writer.newLine()
            }
        }

        writer.close()
    }
}