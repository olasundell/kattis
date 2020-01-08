import kattis.CostumeContest
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

class CostumeContestTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, CostumeContest()::solve)
    }
}