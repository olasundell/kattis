import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class PlantingTreesTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new PlantingTrees()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new PlantingTrees()::solve);
    }

    @Override
    protected String getDir() {
        return "plantingtrees";
    }
}