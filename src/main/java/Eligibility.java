import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 * if the student first began post-secondary studies in 2010 or later, the student is eligible;
 *
 * if the student is born in 1991 or later, the student is eligible;
 *
 * if none of the above applies, and the student has completed more than an equivalent of
 * 8 semesters of full-time study, the student is ineligible;
 *
 * if none of the above applies, the coach may petition for an extension of eligibility
 * by providing the student’s academic and work history.
 *
 * For “equivalent of 8 semesters of full-time study,” we consider each semester of full-time study
 * to be equivalent to a student completing 5 courses. Thus, a student who has completed 41 courses or more
 * is considered to have more than 8 semesters of full-time study.
 *
 * Input
 * The input consists of a number of cases. The first line contains a positive integer, indicating the number of
 * cases to follow. Each of the cases is specified in one line in the following format
 *

 * name YYYY/MM/DD YYYY/MM/DD courses
 * where name is the name of the student (up to 30 alphabetic characters),
 * the first date given is the date the student first began post-secondary studies,
 * and the second date given is the student’s date of birth. All dates are given in the format above with 4-digit
 * year and 2-digit month and day. courses is a non-negative integer indicating the number of courses
 * that the student has completed.

 * There are at most 1 000 cases.

 * Output
 * For each line of output, print the student’s name, followed by a space, followed by one of the strings
 * eligible, ineligible, and coach petitions
 * as appropriate.

 Sample Input 1	Sample Output 1
 3
 EligibleContestant 2013/09/01 1995/03/12 10
 IneligibleContestant 2009/09/01 1990/12/12 50
 PetitionContestant 2009/09/01 1990/12/12 35
 EligibleContestant eligible
 IneligibleContestant ineligible
 PetitionContestant coach petitions

 */

public class Eligibility {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Eligibility().solve(in));
    }

    public String solve(Scanner in) {
        List<Contestant> contestants = new ArrayList<>();
        in.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu/MM/dd");

        while (in.hasNext()) {
            contestants.add(new Contestant(
                    in.next(),
                    LocalDate.parse(in.next(), formatter),
                    LocalDate.parse(in.next(), formatter),
                    in.nextInt()
            ));
        }

        return contestants.stream()
                .map((c) -> String.format("%s %s", c.name, c.status()))
                .collect(Collectors.joining("\n"));
    }

    protected static class Contestant {
        String name;
        LocalDate born;
        LocalDate started;
        int courses;

        public Contestant(String name, LocalDate started, LocalDate born, int courses) {
            this.name = name;
            this.started = started;
            this.born = born;
            this.courses = courses;
        }

        public String status() {
            if (born.getYear() >= 1991 || started.getYear() >= 2010) {
                return "eligible";
            } else if (courses > 40) {
                return "ineligible";
            } else {
                return "coach petitions";
            }
        }
    }
}
