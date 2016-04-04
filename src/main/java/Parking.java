import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class Parking {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Parking().solve(in));
    }

    public String solve(Scanner in) {
        Map<Long, Integer> parkingPrices = new HashMap<>();

        parkingPrices.put(0L, 0);
        parkingPrices.put(1L, in.nextInt());
        parkingPrices.put(2L, in.nextInt() * 2);
        parkingPrices.put(3L, in.nextInt() * 3);

        Set<Truck> trucks = new HashSet<>();
        
        int minTime = Integer.MAX_VALUE;
        int maxTime = -1;

        while (in.hasNext()) {
            final int arrived = in.nextInt();
            final int departed = in.nextInt();

            if (arrived < minTime) {
                minTime = arrived;
            }

            if (departed > maxTime) {
                maxTime = departed;
            }

            trucks.add(new Truck(arrived, departed));
        }

        int cost = 0;

        for (int i = minTime ; i <= maxTime ; i++) {
            final int currentTime = i;

            cost += parkingPrices.get(trucks.stream()
                    .filter((t) -> t.parked(currentTime))
                    .count());
        }

        return String.valueOf(cost);
    }

    private static class Truck {
        final int arrived;
        final int departed;

        Truck(int arrived, int departed) {
            this.arrived = arrived;
            this.departed = departed;
        }

        boolean parked(int time) {
            return time >= arrived && time < departed;
        }
    }
}
