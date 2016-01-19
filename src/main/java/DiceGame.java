import java.util.Scanner;

/**
 * TODO write documentation
 * Gunnar and Emma play a lot of board games at home, so they own many dice that are not normal 6
 6
 -sided dice. For example they own a die that has 10
 10
 sides with numbers 47,48,…,56
 47
 48
 56
 on it.

 There has been a big storm in Stockholm, so Gunnar and Emma have been stuck at home without electricity for a
 couple of hours. They have finished playing all the games they have, so they came up with a new one.
 Each player has 2 dice which he or she rolls. The player with a bigger sum wins. If both sums are the same,
 the game ends in a tie.

 Task
 Given the description of Gunnar’s and Emma’s dice, which player has higher chances of winning?

 All of their dice have the following property: each die contains numbers a,a+1,…,b
 a
 a
 1
 b
 , where a
 a
 and b
 b
 are the lowest and highest numbers respectively on the die. Each number appears exactly on one side, so the die has b−a+1
 b
 a
 1
 sides.

 Input
 The first line contains four integers a1,b1,a2,b2
 a
 1
 b
 1
 a
 2
 b
 2
 that describe Gunnar’s dice. Die number i
 i
 contains numbers ai,ai+1,…,bi
 a
 i
 a
 i
 1
 b
 i
 on its sides. You may assume that 1≤ai≤bi≤100
 1
 a
 i
 b
 i
 100
 . You can further assume that each die has at least four sides, so ai+3≤bi
 a
 i
 3
 b
 i
 .

 The second line contains the description of Emma’s dice in the same format.

 Output
 Output the name of the player that has higher probability of winning. Output “Tie” if both players have same probability of winning.


 */
public class DiceGame {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new DiceGame().solve(in));
    }

    public String solve(Scanner in) {
        int aLow = in.nextInt();
        int aHigh = in.nextInt();
        int aLow1 = in.nextInt();
        int aHigh1 = in.nextInt();

        double aSum = 0;
        double aInc = 0;

        double bSum = 0;
        double bInc = 0;

        for (int i = aLow; i <= aHigh ; i++ ) {
            for (int j = aLow1; j <= aHigh1 ; j++) {
                aSum += i + j;
                aInc++;
            }
        }

        int bLow = in.nextInt();
        int bHigh = in.nextInt();
        int bLow1 = in.nextInt();
        int bHigh1 = in.nextInt();

        for (int i = bLow; i <= bHigh ; i++ ) {
            for (int j = bLow1; j <= bHigh1 ; j++) {
                bSum += i + j;
                bInc++;
            }
        }

        if ((bSum / bInc) == (aSum / aInc)) {
            return "Tie";
        } else if ((bSum / bInc) > (aSum / aInc)) {
            return "Emma";
        } else {
            return "Gunnar";
        }
    }
}
