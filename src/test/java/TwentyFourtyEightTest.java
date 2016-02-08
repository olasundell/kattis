import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.Matrix;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * TODO write documentation
 */
public class TwentyFourtyEightTest extends AbstractTest {
    int[] row0 = {1, 2, 4, 8};
    int[] row1 = {16, 32, 0, 0};
    int[] row2 = {0, 0, 0, 0};
    int[] row3 = {0, 0, 0, 0};
    int[][] tempBoard = new int[][]{
            row0,
            row1,
            row2,
            row3
    };
    private TwentyFourtyEight twentyFourtyEight;

    @Test
    public void one() throws IOException {
        runTest(1, twentyFourtyEight::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, twentyFourtyEight::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, twentyFourtyEight::solve);
    }

    @Test
    public void four() throws IOException {
        runTest(4, twentyFourtyEight::solve);
    }

    @Test
    public void five() throws IOException {
        runTest(5, twentyFourtyEight::solve);
    }

    @Test
    public void six() throws IOException {
        runTest(6, twentyFourtyEight::solve);
    }

    @Before
    public void setUp() throws Exception {
        twentyFourtyEight = new TwentyFourtyEight();
    }

    @Test
    public void shouldMove() {
        List<Integer> start = Arrays.asList(0, 0, 0, 1);
        List<Integer> result = twentyFourtyEight.moveAndCombine(start);
        List<Integer> expected = Arrays.asList(1, 0, 0, 0);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldAddTrivial() {
        List<Integer> start = Arrays.asList(0, 0, 1, 1);
        List<Integer> result = twentyFourtyEight.moveAndCombine(start);
        List<Integer> expected = Arrays.asList(2, 0, 0, 0);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldAddWithHole() {
        List<Integer> start = Arrays.asList(0, 1, 0, 1);
        List<Integer> result = twentyFourtyEight.moveAndCombine(start);
        List<Integer> expected = Arrays.asList(2, 0, 0, 0);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldAddWithHoleAndOther() {
        List<Integer> start = Arrays.asList(4, 1, 0, 1);
        List<Integer> result = twentyFourtyEight.moveAndCombine(start);
        List<Integer> expected = Arrays.asList(4, 2, 0, 0);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldNotCombineTwice() {
        List<Integer> start = Arrays.asList(2, 2, 4, 0);
        List<Integer> result = twentyFourtyEight.moveAndCombine(start);
        List<Integer> expected = Arrays.asList(4, 4, 0, 0);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldAddSeveral() {
        List<Integer> start = Arrays.asList(2, 2, 2, 2);
        List<Integer> result = twentyFourtyEight.moveAndCombine(start);
        List<Integer> expected = Arrays.asList(4, 4, 0, 0);

        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldGetCorrectTile() {
        int result = twentyFourtyEight.getTile(tempBoard, 0, 0, Matrix.Direction.LEFT);
        Assert.assertEquals(tempBoard[0][0], result);

        result = twentyFourtyEight.getTile(tempBoard, 0, 0, Matrix.Direction.RIGHT);
        Assert.assertEquals(tempBoard[0][3], result);
    }

    @Test
    public void shouldCreateSimpleBoard() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 2, 4, 8),
                Arrays.asList(16, 32, 0, 0),
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0)
                );

        List<List<Integer>> result = twentyFourtyEight.createBoardFromTemp(tempBoard, Matrix.Direction.LEFT);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldCreateAndRotateBoardRight() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(8, 4, 2, 1),
                Arrays.asList(0, 0, 32, 16),
                Arrays.asList(0, 0, 0, 0),
                Arrays.asList(0, 0, 0, 0)
        );

        List<List<Integer>> result = twentyFourtyEight.createBoardFromTemp(tempBoard, Matrix.Direction.RIGHT);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldCreateAndRotateBoardUp() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(1, 16, 0, 0),
                Arrays.asList(2, 32, 0, 0),
                Arrays.asList(4, 0, 0, 0),
                Arrays.asList(8, 0, 0, 0)
        );

        List<List<Integer>> result = twentyFourtyEight.createBoardFromTemp(tempBoard, Matrix.Direction.UP);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldCreateAndRotateBoardDown() {
        List<List<Integer>> expected = Arrays.asList(
                Arrays.asList(0, 0, 0, 8),
                Arrays.asList(0, 0, 0, 4),
                Arrays.asList(0, 0, 32, 2),
                Arrays.asList(0, 0, 16, 1)
        );

        List<List<Integer>> result = twentyFourtyEight.createBoardFromTemp(tempBoard, Matrix.Direction.DOWN);
        Assert.assertEquals(expected, result);
    }

    @Test
    public void shouldPrint() {
        List<List<Integer>> boardDown = twentyFourtyEight.createBoardFromTemp(tempBoard, Matrix.Direction.DOWN);
        String result = twentyFourtyEight.printBoard(boardDown, Matrix.Direction.DOWN);
        List<List<Integer>> boardLeft = twentyFourtyEight.createBoardFromTemp(tempBoard, Matrix.Direction.LEFT);
        String expected = twentyFourtyEight.printBoard(boardLeft, Matrix.Direction.LEFT);
        Assert.assertEquals(expected, result);
    }

    @Override
    protected String getDir() {
        return "2048/";
    }
}