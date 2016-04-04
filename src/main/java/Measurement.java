import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Measurement {
    private final Map<Unit, Conversion> conversions;
    private final Map<String, Unit> aliases;
    private final List<Unit> units;

    public Measurement() {
        conversions = createConversions();
        aliases = createAliases();
        units = Arrays.asList(Unit.values());
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Measurement().solve(in));
    }

    public String solve(Scanner in) {

        int distance = in.nextInt();
        Unit fromUnit = aliases.get(in.next());
        // discard "in"
        in.next();
        Unit toUnit = aliases.get(in.next());

        double factor = getConversion(fromUnit, toUnit);

        return String.valueOf(distance * factor);
    }

    protected double getConversion(Unit fromUnit, Unit toUnit) {
        int fromIndex = units.indexOf(fromUnit);
        int toIndex = units.indexOf(toUnit);

        int min = Math.min(fromIndex, toIndex);
        int max = Math.max(fromIndex, toIndex);

        int conv = 1;

        for (int i = max ; i > min; i--) {
            conv *= conversions.get(units.get(i)).amount;
        }

        if (fromIndex < toIndex) {
            return 1.0 / conv;
        }

        return conv;
    }

    // thou (th)
//    inch (in) 1000 thous
//    foot (ft) 12 inches
//    yard (yd) 3 feet
//    chain (ch) 22 yards
//    furlong (fur) 10 chains
//    mile (mi) 8 furlongs
//    league (lea) 3 miles

    private Map<String, Unit> createAliases() {
        Map<String, Unit> aliases = new HashMap<>();

        aliases.put("th", Unit.THOU);
        aliases.put("thou", Unit.THOU);

        aliases.put("inch", Unit.INCH);
        aliases.put("in", Unit.INCH);

        aliases.put("foot", Unit.FOOT);
        aliases.put("feet", Unit.FOOT);
        aliases.put("ft", Unit.FOOT);

        aliases.put("yard", Unit.YARD);
        aliases.put("yd", Unit.YARD);

        aliases.put("furlong", Unit.FURLONG);
        aliases.put("fur", Unit.FURLONG);

        aliases.put("mile", Unit.MILE);
        aliases.put("mi", Unit.MILE);

        aliases.put("lea", Unit.LEAGUE);
        aliases.put("league", Unit.LEAGUE);

        return aliases;
    }

    private Map<Unit, Conversion> createConversions() {
        Map<Unit, Conversion> conversions = new HashMap<>();

        conversions.put(Unit.INCH, new Conversion(Unit.THOU, 1000));
        conversions.put(Unit.FOOT, new Conversion(Unit.INCH, 12));
        conversions.put(Unit.YARD, new Conversion(Unit.FOOT, 3));
        conversions.put(Unit.CHAIN, new Conversion(Unit.YARD, 22));
        conversions.put(Unit.FURLONG, new Conversion(Unit.CHAIN, 10));
        conversions.put(Unit.MILE, new Conversion(Unit.FURLONG, 8));
        conversions.put(Unit.LEAGUE, new Conversion(Unit.MILE, 3));

        return conversions;
    }

    class Conversion {
        final Unit unit;
        final int amount;

        public Conversion(Unit unit, int amount) {
            this.unit = unit;
            this.amount = amount;
        }
    }

    enum Unit {
        THOU,
        INCH,
        FOOT,
        YARD,
        CHAIN,
        FURLONG,
        MILE,
        LEAGUE
    }
}
