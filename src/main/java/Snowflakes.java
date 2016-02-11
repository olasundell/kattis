import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class Snowflakes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Snowflakes().solve(in));
    }

    public String solve(Scanner in) {
        int testCases = in.nextInt();
        List<Integer> unique = new ArrayList<>();

        for (int i = 0 ; i < testCases ; i++) {
//            unique.add(flakes.size());
            unique.add(longest(in));
        }

        return unique.stream().map(String::valueOf).collect(Collectors.joining("\n"));

    }

    protected int longest(Scanner in) {
        Map<Integer, Integer> lastOccurrence = new HashMap<>();
        int longestLenSoFar = 0;
        int currStartPos = 0;
        int currLength = 0;

        int n = in.nextInt();

        for (int i = 0 ; i < n ; i++) {
            int key = in.nextInt();
            int l = lastOccurrence.getOrDefault(key, -1);
            if (l < currStartPos) {
                currLength++;
            } else {
                if (currLength > longestLenSoFar) {
                    longestLenSoFar = currLength;
                }

                currLength -= l - currStartPos;
                currStartPos = l + 1;
            }

            lastOccurrence.put(key, i);

            if (currLength > longestLenSoFar) {
                longestLenSoFar = currLength;
            }
        }

        return longestLenSoFar;
    }
//    def longest_unique_substr(S):
//            # This should be replaced by an array (size = alphabet size).
//    last_occurrence = {}
//    longest_len_so_far = 0
//    longest_pos_so_far = 0
//    curr_starting_pos = 0
//    curr_length = 0
//
//            for k, c in enumerate(S):
//    l = last_occurrence.get(c, -1)
//            # If no repetition within window, no problems.
//            if l < curr_starting_pos:
//    curr_length += 1
//            else:
//            # Check if it is the longest so far
//    if curr_length > longest_len_so_far:
//    longest_pos_so_far = curr_starting_pos
//            longest_len_so_far = curr_length
//    # Cut the prefix that has repetition
//    curr_length -= l - curr_starting_pos
//            curr_starting_pos = l + 1
//    # In any case, update last_occurrence
//    last_occurrence[c] = k
//
//    # Maybe the longest substring is a suffix
//    if curr_length > longest_len_so_far:
//    longest_pos_so_far = curr_starting_pos
//            longest_len_so_far = curr_length
//
//    return S[longest_pos_so_far:longest_pos_so_far + longest_len_so_far]

    public String solve2(Scanner in) {
        int testCases = in.nextInt();
        List<Integer> unique = new ArrayList<>();

        for (int i = 0 ; i < testCases ; i++) {
            int n = in.nextInt();
            Set<Integer> flakes = new HashSet<>();
//            Set<Integer> flakes = new LinkedHashSet<>();
//            Set<Integer> flakes = new TreeSet<>();

            for (int j = 0 ; j < n ; j++) {
                flakes.add(in.nextInt());
            }

            unique.add(flakes.size());
        }

        return unique.stream().map(String::valueOf).collect(Collectors.joining("\n"));
    }
}
