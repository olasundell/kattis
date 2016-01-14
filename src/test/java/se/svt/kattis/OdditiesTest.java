package se.svt.kattis;

import org.junit.Test;

import java.io.IOException;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class OdditiesTest extends AbstractTest {

    @Test
    public void one() throws IOException {
        runTest(1, new Oddities()::solve);
    }

    @Override
    protected String getDir() {
        return "oddities/";
    }
}