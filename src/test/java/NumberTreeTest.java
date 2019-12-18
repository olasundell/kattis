import org.junit.Before;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class NumberTreeTest extends AbstractTest {
	private NumberTree numberTree;

	@Before
	public void setUp() throws Exception {
		numberTree = new NumberTree();
	}

	@Test
	public void one() throws IOException {
		runTest(1, numberTree::solve);
	}

	@Test
	public void two() throws IOException {
		runTest(2, numberTree::solve);
	}

	@Test
	public void three() throws IOException {
		runTest(3, numberTree::solve);
	}

//	@Test
//	public void createSimpleTreeShouldWork() {
//		NumberTree.kattis.Node node = numberTree.createTree(1);
//
//		Assert.assertNotNull(node);
//		Assert.assertNotNull(node.left);
//		Assert.assertNotNull(node.right);
//		Assert.assertEquals(3, node.value);
//	}
//
//	@Test
//	public void createMoreComplexTreeShouldWork() {
//		NumberTree.kattis.Node node = numberTree.createTree(3);
//
//		Assert.assertNotNull(node);
//		Assert.assertNotNull(node.left);
//		Assert.assertNotNull(node.right);
//		Assert.assertEquals(15, node.value);
//		Assert.assertEquals(14, node.left.value);
//		Assert.assertEquals(13, node.right.value);
//		Assert.assertEquals(12, node.left.left.value);
//		Assert.assertEquals(11, node.left.right.value);
//	}
//
//	@Test
//	public void shouldCreateGiantTree() {
//		NumberTree.kattis.Node tree = numberTree.createTree(30);
//	}

	@Override
	protected String getDir() {
		return "numbertree";
	}
}