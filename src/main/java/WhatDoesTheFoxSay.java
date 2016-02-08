import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class WhatDoesTheFoxSay {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new WhatDoesTheFoxSay().solve(in));
    }

    public String solve(Scanner in) {
        int n = in.nextInt();
        List<String> lines = new ArrayList<>();

        for (int i = 0 ; i < n ; i++) {
            in.nextLine();
            List<String> sounds = Arrays.asList(in.nextLine().split(" "));
            Set<String> knownSounds = new HashSet<>();

            while (in.hasNext()) {
                String line = in.nextLine();
                if (!"what does the fox say?".equals(line) && line.matches(".+ goes .+")) {
                    knownSounds.add(line.split(" ")[2]);
                }
            }
            String collect = sounds.stream()
                    .filter((s) -> !knownSounds.contains(s))
                    .collect(Collectors.joining(" "));
            lines.add(collect);
        }

        return lines.stream().collect(Collectors.joining("\n"));
    }
}
