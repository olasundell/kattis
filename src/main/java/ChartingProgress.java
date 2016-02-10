import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class ChartingProgress {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println(new ChartingProgress().solve(in));
    }

    public String solve(Scanner in) {
        List<Board> boards = new ArrayList<>();
        Board currentBoard = new Board();
        boards.add(currentBoard);

        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.isEmpty()) {
                currentBoard = new Board();
                boards.add(currentBoard);
            } else {
                if (currentBoard.isEmpty()) {
                    for (int i = 0 ; i < s.length() ; i++) {
                        currentBoard.add(new Column());
                    }
                }

                for (int i = 0 ; i < s.length() ; i++) {
                    if (s.charAt(i) == '*') {
                        currentBoard.setColVal(i);
                    }
                }

                currentBoard.incHeight();
            }
        }

        return boards.stream()
                .map((b) -> {
                    b.sort();
                    return b.toString();
                    })
                .collect(Collectors.joining("\n\n"));
    }

    protected static class Board {
        List<Column> columns = new ArrayList<>();
        int height;

        public boolean isEmpty() {
            return columns.isEmpty();
        }

        public void add(Column column) {
            columns.add(column);
        }

        public void setColVal(int i) {
            columns.get(i).val = height;
        }

        public void incHeight() {
            height++;
        }

        public void sort() {
            Collections.sort(columns);
        }

        public String toString() {
            StringBuilder builder = new StringBuilder();
            for (int i = 0 ; i < height ; i++) {
                for (Column c: columns) {
                    if (c.val == i) {
                        builder.append('*');
                    } else {
                        builder.append('.');
                    }
                }

                if (i < height - 1) {
                    builder.append('\n');
                }
            }

            return builder.toString();
        }
    }

    protected static class Column implements Comparable<Column> {
        int val;

        @Override
        public int compareTo(Column o) {
            return o.val - val;
        }
    }
}
