import java.util.Arrays;
import java.util.Scanner;

/**
 * TODO write documentation
 */
public class Toilet {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new Toilet().solve(in));
    }

    public String solve(Scanner in) {
        String line = in.next();
        int upStrategy = 0;
        int downStrategy = 0;
        int leaveStrategy = 0;

	    char[] lineC = line.toCharArray();

	    char[] chars = Arrays.copyOfRange(lineC, 1, lineC.length);

	    boolean up = lineC[0] == 'U';
	    // strategy up
        for (char c: chars) {
	        if (up && c == 'D') {
		        upStrategy += 2;
	        }

        	if (!up) {
        		upStrategy++;
		        up = true;
	        }
        }

	    up = lineC[0] == 'U';

	    // strategy down
        for (char c: chars) {
        	if (!up && c == 'U') {
        		downStrategy += 2;
	        }

	        if (up) {
	        	downStrategy++;
		        up = false;
	        }
        }

	    up = lineC[0] == 'U';

	    for (char c: chars) {
	    	if (c == 'U' && !up) {
	    		up = true;
			    leaveStrategy++;
		    } else if (c == 'D' && up) {
			    up = false;
			    leaveStrategy++;
		    }
	    }

        return String.format("%d\n%d\n%d",
		        upStrategy,
		        downStrategy,
		        leaveStrategy);
    }
}
