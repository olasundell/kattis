import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class MapTilesTwoTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new MapTilesTwo()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new MapTilesTwo()::solve);
    }

    @Override
    protected String getDir() {
        return "maptiles2";
    }
}