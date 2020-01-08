import kattis.IcpcAwards
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class IcpcAwardsTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, IcpcAwards()::solve)
    }
}
