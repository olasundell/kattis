import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * TODO write documentation
 */
public class WhatDoesTheFoxSayTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new WhatDoesTheFoxSay()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new WhatDoesTheFoxSay()::solve);
    }

    @Test
    public void three() throws IOException {
        runTest(3, new WhatDoesTheFoxSay()::solve);
    }

    @Test
    public void four() throws IOException {
        runTest(4, new WhatDoesTheFoxSay()::solve);
    }

    @Override
    protected String getDir() {
        return "whatdoesthefoxsay";
    }
}