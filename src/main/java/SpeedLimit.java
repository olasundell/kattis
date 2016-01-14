import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class SpeedLimit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new SpeedLimit().solve(in));
    }

    public String solve(Scanner in) {
        List<Distance> distances = new ArrayList<>();
        int n;

        while ((n = in.nextInt()) != -1){
            int totalDistance = 0;
            int prevHour = 0;
            for (int i = 0 ; i < n ; i++) {
                int speed = in.nextInt();
                int currentHour = in.nextInt();
                totalDistance += (currentHour - prevHour) * speed;
                prevHour = currentHour;
            }
            distances.add(new Distance(totalDistance));
        }

        return distances.stream()
                .map(Distance::toString)
                .collect(Collectors.joining("\n"));
    }

    public static class Distance {
        final int miles;

        public Distance(int miles) {
            this.miles = miles;
        }

        @Override
        public String toString() {
            return String.format("%d miles", miles);
        }
    }
}
