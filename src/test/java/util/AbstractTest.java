package util;

import org.junit.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * TODO write documentation
 */
public abstract class AbstractTest {
    protected final static String DIR = "src/test/resources/";

	public void writeToFile(String test, int num, Consumer<SafeWriter> inConsumer, Consumer<SafeWriter> ansConsumer) throws IOException {
		File in = new File("/Users/olasundell/code/kattis/src/test/resources/" + test + "/" + num + ".in");
		File ans = new File("/Users/olasundell/code/kattis/src/test/resources/" + test + "/" + num +".ans");

		SafeWriter inWriter = new SafeWriter(in);
		inConsumer.accept(inWriter);
		inWriter.close();

		SafeWriter ansWriter = new SafeWriter(ans);
		ansConsumer.accept(ansWriter);
		ansWriter.close();
	}

	public static class SafeWriter extends FileWriter {
		public SafeWriter(File file) throws IOException {
			super(file);
		}

		@Override
		public void write(String str) {
			try {
				super.write(str);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract String getDir();

    protected void runTest(int i, Function<Scanner, String> function) throws IOException {
        String result = function.apply(buildScanner(i + ".in"));
        String expected = readFile(i + ".ans");
        Assert.assertEquals(expected, result);
    }

    protected Scanner buildScanner(String s) throws FileNotFoundException {
	    final File source = new File(DIR + getSafeDir() + s);
	    if (source.exists()) {
		    return new Scanner(source);
	    } else {
		    final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(getSafeDir() + s);
		    return new Scanner(resourceAsStream);
	    }
    }

    // TODO this could probably be slightly cleaner
    protected String getSafeDir() {
        String dir = getDir();

        if (!dir.endsWith("/")) {
            return dir + "/";
        } else {
            return dir;
        }
    }

    protected String readFile(String fileName) throws IOException {
	    List<String> solution = new ArrayList<>();
	    String line;

	    Reader in;

	    if (new File(DIR + getSafeDir() + fileName).exists()) {
		    in = new FileReader(DIR + getSafeDir() + fileName);
	    } else {
		    final InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream(getSafeDir() + fileName);
	    	in = new InputStreamReader(resourceAsStream);
	    }
	    final BufferedReader reader = new BufferedReader(in);

	    while ((line = reader.readLine()) != null) {
		    solution.add(line);
	    }

	    return String.join("\n", solution);
    }
}
