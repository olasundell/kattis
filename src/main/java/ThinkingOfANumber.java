import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class ThinkingOfANumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new ThinkingOfANumber().solve(in));
    }

    public String solve(Scanner in) {
        int n = -1;
        Rules currentRules;
        List<String> results = new ArrayList<>();

        while ((n = in.nextInt()) != 0) {
            currentRules = new Rules();
            in.nextLine();
            for (int i = 0; i < n; i++) {
                String rule = in.nextLine();
                int ruleNum = Integer.valueOf(rule.replaceAll("[^0-9]", ""));

                if (rule.startsWith("less than")) {
                    currentRules.lessThan = ruleNum;
                } else if (rule.startsWith("greater than")) {
                    currentRules.greaterThan = ruleNum;
                } else if (rule.startsWith("divisible by")) {
                    currentRules.addDivisibleBy(ruleNum);
                }
            }

            if (currentRules.getLCM() == 1) {
                results.add("infinite");
                continue;
            }

            List<Integer> currentResult = new ArrayList<>();

            for (int j = currentRules.getGreaterThan();
                 j <= currentRules.getLessThan();
                 j += currentRules.getLCM()) {

                currentResult.add(j);
            }

            if (currentResult.isEmpty()) {
                results.add("none");
            } else {
                results.add(currentResult.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
        }

        return results.stream().collect(Collectors.joining("\n"));
    }

    public static class Rules {
        int greaterThan = 0;
        int greaterThanLcm = -1;
        int lessThan = Integer.MAX_VALUE;
        int lessThanLcm = Integer.MAX_VALUE;
        int leastCommonMultiple = -1;

        List<Integer> divisibleBy = new ArrayList<>();

        public void addDivisibleBy(int d) {
            divisibleBy.add(d);
        }

        public int getLCM() {
            if (leastCommonMultiple < 0) {
                leastCommonMultiple = lcm(divisibleBy);
            }

            return leastCommonMultiple;
        }

        private int gcd(int a, int b) {
            while (b > 0) {
                int temp = b;
                b = a % b; // % is remainder
                a = temp;
            }
            return a;
        }

        private int gcd(int[] input) {
            int result = input[0];

            for(int i = 1; i < input.length; i++) {
                result = gcd(result, input[i]);
            }

            return result;
        }

        private int lcm(int a, int b) {
            return a * (b / gcd(a, b));
        }

        private int lcm(List<Integer> input) {
            int result = input.get(0);

            for(int i = 1; i < input.size(); i++) {
                result = lcm(result, input.get(i));
            }

            return result;
        }

        public int getLessThan() {
            if (lessThanLcm == Integer.MAX_VALUE) {
                double lt = lessThan - 1;
                double lcm = getLCM();

                lessThanLcm = ((int) Math.floor(lt / lcm)) * getLCM();

            }
            return lessThanLcm;
        }

        public int getGreaterThan() {
            if (greaterThanLcm < 0) {
                double gt = greaterThan + 1;
                double lcm = getLCM();

                greaterThanLcm = ((int) Math.ceil(gt / lcm)) * getLCM();
            }

            return greaterThanLcm;
        }
    }
}
