import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import util.AbstractTest;

import java.io.IOException;

/**
 * TODO write documentation
 */
public class ThinkingOfANumberTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new ThinkingOfANumber()::solve);
    }

    @Test
    @Ignore("faulty test data")
    public void two() throws IOException {
        runTest(2, new ThinkingOfANumber()::solve);
    }

    @Test
    public void leastCommonMultiple() {
        ThinkingOfANumber.Rules rules = new ThinkingOfANumber.Rules();

        rules.addDivisibleBy(4);
        rules.addDivisibleBy(7);
        rules.addDivisibleBy(12);
        rules.addDivisibleBy(21);
        rules.addDivisibleBy(42);

        Assert.assertEquals(84, rules.getLCM());
    }

    @Test
    public void getLessThanSimple() {
        ThinkingOfANumber.Rules rules = new ThinkingOfANumber.Rules();

        rules.addDivisibleBy(5);
        rules.lessThan = 13;
        Assert.assertEquals(10, rules.getLessThan());
    }

    @Test
    public void getLessThanLittleHarder() {
        ThinkingOfANumber.Rules rules = new ThinkingOfANumber.Rules();

        rules.addDivisibleBy(3);
        rules.addDivisibleBy(7);
        rules.lessThan = 100;
        Assert.assertEquals(84, rules.getLessThan());
    }


    @Override
    protected String getDir() {
        return "thinkingofanumber";
    }
}