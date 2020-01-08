import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.util.Scanner;

/**
 * TODO write documentation
 */
public class MeasurementTest extends AbstractTest {

    private Measurement measurement;

    @BeforeEach
    public void setUp() throws Exception {
        measurement = new Measurement();
    }

    @Test
    public void shouldParse() {
        Assertions.assertEquals("504.0", measurement.solve(new Scanner("42 ft in inch")));
        Assertions.assertTrue(measurement.solve(new Scanner("10 furlong in lea")).startsWith("0.41666666"));
    }

    @Test
    public void simpleConversionShouldWork() {
        Assertions.assertEquals(1000.0, measurement.getConversion(Measurement.Unit.INCH, Measurement.Unit.THOU), 0.00001);
    }

    @Test
    public void simpleReverseConversion() {
        Assertions.assertEquals(1 / 1000.0, measurement.getConversion( Measurement.Unit.THOU, Measurement.Unit.INCH ), 0.0001);
    }

    @Test
    public void longerConversionShouldWork() {
        Assertions.assertEquals(5280.0, measurement.getConversion(Measurement.Unit.MILE, Measurement.Unit.FOOT), 0.1);
    }

    @Test
    public void selfConversionShouldWork() {
    	for (Measurement.Unit unit : Measurement.Unit.values()) {
            Assertions.assertEquals(1.0, measurement.getConversion(unit, unit), 0.1);
        }
    }

    @Test
    public void loopAllConversions() {
        Measurement.Unit[] values = Measurement.Unit.values();
        for (int i = 0 ; i < values.length - 1 ; i++) {
            measurement.getConversion(values[i], values[i + 1]);
            measurement.getConversion(values[values.length - i - 1], values[values.length - i - 2]);
        }

    }

    @Test
    public void longerReverseConversionShouldWork() {
        Assertions.assertEquals(1 / 5280.0, measurement.getConversion( Measurement.Unit.FOOT, Measurement.Unit.MILE ), 0.00001);
    }

    @Override
    protected String getDir() {
        return "measurement";
    }
}