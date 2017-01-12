package hackerrank;

import org.junit.Assert;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class SubstringDiffTest extends AbstractTest {
	@Test
	public void one() throws IOException {
		runTest(1, new SubstringDiff()::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, new SubstringDiff()::solve);
	}

	@Test
	public void slideSimplest() {
		int result = new SubstringDiff().letItSlide("a", "a", 0);
		Assert.assertEquals(1, result);
	}

	@Test
	public void slideSimple() {
		int result = new SubstringDiff().letItSlide("abcd", "abcd", 0);
		Assert.assertEquals(4, result);
	}

	@Test
	public void slideOneDiff() {
		int result = new SubstringDiff().letItSlide("aecd", "abcd", 1);
		Assert.assertEquals(4, result);
	}

	@Test
	public void slideMinorDiff() {
		int result = new SubstringDiff().letItSlide("aecd", "abcd", 0);
		Assert.assertEquals(2, result);
	}

	@Test
	public void slideDiffAtEnd() {
		int result = new SubstringDiff().letItSlide("abce", "abcd", 0);
		Assert.assertEquals(3, result);
	}

	@Test
	public void slideDiffAtBeginning() {
		int result = new SubstringDiff().letItSlide("xbcd", "abcd", 0);
		Assert.assertEquals(3, result);
	}

	@Test
	public void slideNoMatch() {
		int result = new SubstringDiff().letItSlide("xxxx", "abcd", 0);
		Assert.assertEquals(0, result);
	}

//	@Test
	public void slideTwoDiff() {
		int result = new SubstringDiff().letItSlide("tabriz", "torino", 2);
		Assert.assertEquals(4, result);
	}

	@Override
	protected String getDir() {
		return "hackerrank/substringdiff";
	}
}