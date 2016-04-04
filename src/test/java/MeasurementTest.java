import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class MeasurementTest extends AbstractTest {

    private Measurement measurement;

    @Before
    public void setUp() throws Exception {
        measurement = new Measurement();
    }

    @Test
    @Ignore("Rounding errors")
    public void one() throws IOException {
        runTest(1, measurement::solve);
    }

    @Test
    @Ignore("Rounding errors")
    public void two() throws IOException {
        runTest(2, measurement::solve);
    }

    @Test
    public void simpleConversionShouldWork() {
        Assert.assertEquals(1000.0, measurement.getConversion(Measurement.Unit.INCH, Measurement.Unit.THOU), 0.00001);
    }

    @Test
    public void simpleReverseConversion() {
        Assert.assertEquals(1 / 1000.0, measurement.getConversion( Measurement.Unit.THOU, Measurement.Unit.INCH ), 0.0001);
    }

    @Test
    public void longerConversionShouldWork() {
        Assert.assertEquals(5280.0, measurement.getConversion(Measurement.Unit.MILE, Measurement.Unit.FOOT), 0.1);
    }

    @Test
    public void longerReverseConversionShouldWork() {
        Assert.assertEquals(1 / 5280.0, measurement.getConversion( Measurement.Unit.FOOT, Measurement.Unit.MILE ), 0.00001);
    }

    @Override
    protected String getDir() {
        return "measurement";
    }
}