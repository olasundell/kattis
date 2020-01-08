import kattis.LicenseToLaunch
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class LicenseToLaunchTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, LicenseToLaunch()::solve)
    }
}