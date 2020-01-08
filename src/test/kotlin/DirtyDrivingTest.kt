import kattis.DirtyDriving
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

class DirtyDrivingTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, DirtyDriving()::solve)
    }

    @Test
    fun two() {
        runTest(2, DirtyDriving()::solve)
    }
}