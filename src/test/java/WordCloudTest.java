import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class WordCloudTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new WordCloud()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new WordCloud()::solve);
	}

	@Override
	protected String getDir() {
		return "wordcloud";
	}
}