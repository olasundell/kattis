import kattis.Warehouse
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class WarehouseTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Warehouse()::solve)
    }
}