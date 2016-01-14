import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Towers {
    protected final static Comparator<TowerNum> TOWER_NUM_COMPARATOR = (n, n1) -> {
        int signum = n.value.subtract(n1.value).signum();

        if (signum == 0) {
            return n.index - n1.index;
        } else {
            return signum;
        }
    };

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Towers().solve(in));
    }

    public String solve(Scanner in) {
        int lines = in.nextInt();
        List<TowerNum> numbers = new ArrayList<>();

        for (int i = 0 ; i < lines ; i++) {
            numbers.add(new TowerNum(in.next(), i));
        }

        Collections.sort(numbers, TOWER_NUM_COMPARATOR);

        return "Case 1:\n" + numbers.stream().map((t) -> t.str).collect(Collectors.joining("\n"));
    }

    public static class TowerNum {
        BigInteger value;
        String str;
        int index;

        public TowerNum(String s, int index) {
            this.index = index;
            this.str = s;
            List<String> split = Arrays.asList(s.split("\\^"));

            if (split.isEmpty()) {
                value = new BigInteger(s);
            } else if (split.size() == 1) {
                value = new BigInteger(split.get(0));
            } else {
                List<BigInteger> collect = split.stream().map(BigInteger::new).collect(Collectors.toList());
                Collections.reverse(collect);

                Deque<BigInteger> queue = new ArrayDeque<>(collect);

                while (queue.size() != 1) {
                    BigInteger a = queue.remove();
                    BigInteger b = queue.remove();

                    BigInteger e = pow(b, a);
                    queue.addFirst(e);
                }

                value = queue.remove();
            }
        }

        @Override
        public String toString() {
            return "TowerNum{" +
                    "value=" + value +
                    ", str='" + str + '\'' +
                    ", index=" + index +
                    '}';
        }

        private BigInteger pow(BigInteger x, BigInteger y) {
            if (y.compareTo(BigInteger.ZERO) < 0)
                throw new IllegalArgumentException();
            BigInteger z = x; // z will successively become x^2, x^4, x^8, x^16, x^32...
            BigInteger result = BigInteger.ONE;
            byte[] bytes = y.toByteArray();
            for (int i = bytes.length - 1; i >= 0; i--) {
                byte bits = bytes[i];
                for (int j = 0; j < 8; j++) {
                    if ((bits & 1) != 0)
                        result = result.multiply(z);
                    // short cut out if there are no more bits to handle:
                    if ((bits >>= 1) == 0 && i == 0)
                        return result;
                    z = z.multiply(z);
                }
            }
            return result;
        }
    }
}
