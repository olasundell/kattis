import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Vauvau {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Vauvau().solve(in));
    }

    public String solve(Scanner in) {
        List<String> attacks = new ArrayList<>();
        int aAgg = in.nextInt();
        int aSleep = in.nextInt();
        int bAgg = in.nextInt();
        int bSleep = in.nextInt();

        int postMan = in.nextInt();
        int milkMan = in.nextInt();
        int garbageMan = in.nextInt();

        attacks.add(attack(postMan, aAgg, aSleep, bAgg, bSleep));
        attacks.add(attack(milkMan, aAgg, aSleep, bAgg, bSleep));
        attacks.add(attack(garbageMan, aAgg, aSleep, bAgg, bSleep));

        return attacks.stream().collect(Collectors.joining("\n"));
    }

    // WHOA! Way too many parameters.
    private String attack(int arrive, int aAgg, int aSleep, int bAgg, int bSleep) {
        int dogs = 0;

        int i = arrive % (aAgg + aSleep);
        if (i != 0 && i <= aAgg)  {
            dogs++;
        }

        int i1 = arrive % (bAgg + bSleep);
        if (i1 != 0 && i1 <= bAgg)  {
            dogs++;
        }

        switch (dogs) {
            case 0:
                return "none";
            case 1:
                return "one";
            case 2:
                return "both";
        }

        throw new IllegalStateException(dogs + " is too many or too few goddamned dogs!");
    }
}
