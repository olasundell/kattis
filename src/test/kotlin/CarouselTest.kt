import org.junit.Test
import util.AbstractKotlinTest

/**
 * TODO write documentation
 */
class CarouselTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Carousel()::solve)
    }
}