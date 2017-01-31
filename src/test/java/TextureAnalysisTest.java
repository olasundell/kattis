import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class TextureAnalysisTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new TextureAnalysis()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new TextureAnalysis()::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, new TextureAnalysis()::solve);
	}

	@Test
	public void four() throws IOException {
		runTest(4, new TextureAnalysis()::solve);
	}

	@Override
	protected String getDir() {
		return "textureanalysis";
	}
}