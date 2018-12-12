import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

class CostumeContestTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, CostumeContest()::solve)
    }
}