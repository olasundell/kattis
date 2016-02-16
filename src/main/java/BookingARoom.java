import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * TODO write documentation
 */
public class BookingARoom {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new BookingARoom().solve(in));
    }

    public String solve(Scanner in) {
        int availableRooms = in.nextInt();
        int bookedRooms = in.nextInt();

        if (availableRooms == bookedRooms) {
            return "too late";
        }

        Set<Integer> occupiedRooms = new HashSet<>();

        while (in.hasNextInt()) {
            occupiedRooms.add(in.nextInt());
        }

        for (int i = 1 ; i <= availableRooms ; i++) {
            if (!occupiedRooms.contains(i)) {
                return String.valueOf(i);
            }
        }

        return "";
    }
}
