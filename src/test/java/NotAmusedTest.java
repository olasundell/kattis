import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.AbstractTest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * TODO write documentation
 */
public class NotAmusedTest extends AbstractTest {

    public static final String NAME = "foo";
    private NotAmused.Visit visit;
    private NotAmused.Visit visit2;
    private NotAmused.Person person;

    @BeforeEach
    public void setUp() throws Exception {
        visit = new NotAmused.Visit();

        visit.enter = 120;
        visit.exit = 181;

        visit2 = new NotAmused.Visit();

        visit2.enter = 220;
        visit2.exit = 281;

        person = new NotAmused.Person(NAME);

        person.addVisit(visit);
        person.addVisit(visit2);
    }

    @Test
    public void one() throws IOException {
        runTest(1, new NotAmused()::solve);
    }

    @Test
    public void two() throws IOException {
        runTest(2, new NotAmused()::solve);
    }

    @Test
    public void shouldCalculateVisit() {
        assertEquals(6.10, visit.sum(), 0.01);
    }

    @Test
    public void shouldSumVisits() {
        assertEquals(12.2, person.sum(), 0.01);
    }

    @Test
    public void shouldEnterAndExit() {
        NotAmused.Person eePerson = new NotAmused.Person(NAME);
        eePerson.enter(60);
        eePerson.exit(62);

        eePerson.enter(70);
        eePerson.exit(72);

        assertEquals(0.40, eePerson.sum(), 0.01);
    }

    @Test
    public void shouldToStringPerson() {
        assertEquals(NAME + " $12.20", person.toString());
    }

    @Test
    public void shouldToStringDay() {
        NotAmused.Day day = new NotAmused.Day(1);
        day.addPerson(person);

        assertEquals("Day 1\nfoo $12.20", day.toString());
    }

    @Override
    protected String getDir() {
        return "notamused";
    }
}