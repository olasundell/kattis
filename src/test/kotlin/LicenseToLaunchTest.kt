import util.AbstractKotlinTest

import org.junit.Assert.*
import org.junit.Test

/**
 * TODO write documentation
 */
class LicenseToLaunchTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, LicenseToLaunch()::solve)
    }
}