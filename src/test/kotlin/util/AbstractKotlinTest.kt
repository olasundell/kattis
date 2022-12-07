package util

import org.junit.jupiter.api.Assertions
import util.AbstractTest.DIR
import java.io.*
import java.net.URL
import java.util.*
import kotlin.jvm.internal.FunctionReference

/**
 * TODO write documentation
 */

abstract class AbstractKotlinTest {
    fun runTest(i: Int, f: (Scanner) -> String) {
        val prefix = prefix((f as FunctionReference).boundReceiver.javaClass)
        val result = f(buildScanner("$prefix$i.in"))
        val expected = readFile("$prefix$i.ans").trim()
        Assertions.assertEquals(expected, result)
    }

    fun runAllTests(f: (Scanner) -> String) {
        File(getDir()).walk().filter { it.endsWith(".in") }.forEach { runTest(it.name.replace(".in", "").toInt(), f) }
    }

    fun <T> readFile(i: Int, javaClass: Class<T>): String {
        val prefix = prefix(javaClass)
        val s = "$prefix$i.in"
        val resource = this::class.java.getResource(s)
        return resource.readText()
    }

    private fun <T> prefix(javaClass: Class<T>): String {
        val name: String = javaClass.name
        return if (!name.isBlank()) {
            val replace = name.replace('.', '/')
                    .toLowerCase()
            "/$replace/"
        } else {
            ""
        }
    }

    fun runTestTokenizer(i: Int, f: (StreamTokenizer) -> String) {
        val result = f(buildStreamTokenizer("$i.in"))
        val expected = readFile("$i.ans").trim()
        Assertions.assertEquals(expected, result)
    }

    private fun buildStreamTokenizer(s: String): StreamTokenizer {
        return StreamTokenizer(buildReader(s))
    }

    private fun buildReader(s: String): Reader {
        val dir = getDir()
        val s1 = DIR + dir + s
        val file = File(s1)

        return if (file.exists()) {
            FileReader(file)
        } else {
            val resource = this::class.java.getResource(dir + s)
            val text = resource.readText()
            StringReader(text)
        }
    }

    private fun buildScanner(s: String): Scanner {
        val file = File(s)

        if (file.exists()) {
            return Scanner(file);
        } else {
            val resource: URL? = this::class.java.getResource(s)
            val text = resource?.readText() ?: throw IllegalStateException("Could not find file $s")
            return Scanner(text)
        }
    }

    private fun getDir(): String =
            prefix(this.javaClass) +
                    this.javaClass.name.replace('.','/')
            .replace("Test".toRegex(), "/")
            .toLowerCase()

    fun readFile(name: String): String {
        val resource: URL? = this::class.java.getResource(name)
        return resource?.readText() ?: throw IllegalStateException(name)
    }
}
