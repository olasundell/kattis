import kattis.Prerequisites
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class PrerequisitesTest: AbstractKotlinTest() {
    @Test
    fun enoughInCategoryTest() {
        val category1 = Prerequisites.Category(1, setOf(22, 33))
        val category2 = Prerequisites.Category(2, setOf(11, 22, 33))

        Assertions.assertTrue(Prerequisites().enoughInCategory(category1, setOf(22, 44)))
        Assertions.assertFalse(Prerequisites().enoughInCategory(category1, setOf(44, 55)))
        Assertions.assertTrue(Prerequisites().enoughInCategory(category2, setOf(11, 33, 44)))
    }
    @Test
    fun one() {
        runTest(1, Prerequisites()::solve)
    }
}