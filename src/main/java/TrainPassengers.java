import java.util.Scanner;

/**
 * TODO write documentation
 */
public class TrainPassengers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new TrainPassengers().solve(in));
    }

    public String solve(Scanner in) {
        int totalCap = in.nextInt();
        int stations = in.nextInt();

        int onTrain = 0;

        for (int i = 0 ; i < stations ; i++) {
            int leaving = in.nextInt();
            int entering = in.nextInt();
            int leftOnStation = in.nextInt();

            onTrain += entering - leaving;

            if (onTrain > totalCap) {
                return "impossible";
            }

            if (onTrain < totalCap && leftOnStation > 0) {
                return "impossible";
            }

            if (onTrain < 0) {
                return "impossible";
            }
        }

        if (onTrain != 0) {
            return "impossible";
        }

        return "possible";
    }
}
