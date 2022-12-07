package codingame

import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class SpreadSheetTest : AbstractKotlinTest() {
	@Test
	fun one() {
		runTest(1, `1DSpreadSheet`()::solve)
	}

	@Test
	fun ten() {
		runTest(10, `1DSpreadSheet`()::solve)
	}

	@Test
	fun eleven() {
		runTest(11, `1DSpreadSheet`()::solve)
	}

	@Test
	fun thirteen() {
		runTest(13, `1DSpreadSheet`()::solve)
	}
}