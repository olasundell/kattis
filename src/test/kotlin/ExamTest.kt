import kattis.Exam
import util.AbstractKotlinTest

import org.junit.jupiter.api.Test

/**
 * TODO write documentation
 */
class ExamTest : AbstractKotlinTest() {
    @Test
    fun one() {
        runTest(1, Exam()::solve)
    }

    @Test
    fun two() {
        runTest(2, Exam()::solve)
    }

    @Test
    fun three() {
        runTest(3, Exam()::solve)
    }

    @Test
    fun four() {
        runTest(4, Exam()::solve)
    }

    @Test
    fun five() {
        runTest(5, Exam()::solve)
    }

    @Test
    fun six() {
        runTest(6, Exam()::solve)
    }
}