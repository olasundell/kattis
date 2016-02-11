import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class BlackFriday {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new BlackFriday().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();

        Map<Integer, List<Roll>> dieRolls = new HashMap<>();

        for (int i = 0 ; i < n ; i++) {
            int roll = in.nextInt();
            List<Roll> rolls = dieRolls.getOrDefault(roll, new ArrayList<>());
            rolls.add(new Roll(i + 1));

            if (rolls.size() == 1) {
                dieRolls.put(roll, rolls);
            }

        }

        for (int i = 6 ; i >= 1 ; i--) {
            List<Roll> rolls = dieRolls.getOrDefault(i, Collections.EMPTY_LIST);
            if (rolls.size() == 1) {
                return String.valueOf(rolls.get(0).placeInQueue);
            }
        }

        return "none";
    }

    private static class Roll {
        final int placeInQueue;

        public Roll(int placeInQueue) {
            this.placeInQueue = placeInQueue;
        }
    }
}
