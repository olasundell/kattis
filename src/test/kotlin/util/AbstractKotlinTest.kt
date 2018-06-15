package util

import org.junit.Assert
import util.AbstractTest.DIR
import java.io.*
import java.util.*
import java.util.stream.Collectors

/**
 * TODO write documentation
 */

abstract class AbstractKotlinTest {
    fun runTest(i: Int, f: (Scanner) -> String) {
        val result = f(buildScanner("$i.in"))
        val expected = readFile("$i.ans").trim()
        Assert.assertEquals(expected, result)
    }

    fun runTestTokenizer(i: Int, f: (StreamTokenizer) -> String) {
        val result = f(buildStreamTokenizer("$i.in"))
        val expected = readFile("$i.ans").trim()
        Assert.assertEquals(expected, result)
    }

    private fun buildStreamTokenizer(s: String): StreamTokenizer {
        val dir = getDir()
        val s1 = DIR + dir + s
        val file = File(s1)

        if (file.exists()) {
            return StreamTokenizer(FileReader(file));
        } else {
            val resource = this::class.java.getResource(dir + s)
            val text = resource.readText()
            return StreamTokenizer(StringReader(text))
        }
    }

    private fun buildScanner(s: String): Scanner {
        val dir = getDir()
        val s1 = DIR + dir + s
        val file = File(s1)

        if (file.exists()) {
            return Scanner(file);
        } else {
            val resource = this::class.java.getResource(dir + s)
            val text = resource.readText()
            return Scanner(text)
        }
    }

    private fun getDir() = this.javaClass.simpleName
            .replace("Test".toRegex(), "/")
            .toLowerCase()

    fun readFile(name: String): String {
        val resource = this::class.java.getResource(getDir() + name)
        return resource.readText()
    }

}
//protected final static String DIR = "src/test/resources/";
//protected abstract String getDir();
//
//protected void runTest(int i, Function<Scanner, String> function) throws IOException {
//    String result = function.apply(buildScanner(i + ".in"));
//    String expected = readFile(i + ".ans");
//    Assert.assertEquals(expected, result);
//}
//
//protected Scanner buildScanner(String s) throws FileNotFoundException {
//    return new Scanner(new File(DIR + getSafeDir() + s));
//}
//
//// TODO this could probably be slightly cleaner
//protected String getSafeDir() {
//    String dir = getDir();
//
//    if (!dir.endsWith("/")) {
//        return dir + "/";
//    } else {
//        return dir;
//    }
//}
//
//protected String readFile(String fileName) throws IOException {
//    List<String> solution = new ArrayList<>();
//    String line;
//
//    final BufferedReader reader = new BufferedReader(new FileReader(DIR + getSafeDir() + fileName));
//
//    while ((line = reader.readLine()) != null) {
//        solution.add(line);
//    }
//
//    return String.join("\n", solution);
//}
