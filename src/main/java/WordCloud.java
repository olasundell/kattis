import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class WordCloud {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new WordCloud().solve(in));
	}

	public String solve(Scanner in) {
		List<Integer> result = new ArrayList<>();

		while (in.hasNextLine()) {
			List<Word> words = new ArrayList<>();
			int maxWidth = in.nextInt();
			int maxCount = setupWordsAndReturnMaxCount(in, words);

			if (maxCount == 0 || words.isEmpty()) {
				break;
			}

			System.err.println("=== New test w: " + maxWidth + " c: " + maxCount);

			int totalHeight = getTotalHeight(words, maxWidth, maxCount);

			System.err.println();
			System.err.println("=== Adding total " + totalHeight + " ===");
			System.err.println();
			result.add(totalHeight);
		}

		AtomicInteger integer = new AtomicInteger(1);

		return result.stream()
				.map(r -> "CLOUD " + integer.getAndIncrement() + ": " + String.valueOf(r))
				.collect(Collectors.joining("\n"));
	}

	private int getTotalHeight(List<Word> words, int maxWidth, int maxCount) {
		int currWidth = 0;
		int rowHeight = 0;
		int totalHeight = 0;

		for (int i = 0 ; i < words.size() ; i++) {
			Word word = words.get(i);
			int w = word.width(maxCount);
			int h = word.size(maxCount);


			if (currWidth == 0) {
				currWidth = w;
				rowHeight = h;
			} else if (currWidth + w + 10 > maxWidth) {
				totalHeight += rowHeight;
				System.err.println(" rh: " + rowHeight + " cw: " + currWidth);
				// reset
				currWidth = w;
				rowHeight = h;
			} else {
				if (h > rowHeight) {
					rowHeight = h;
				}
				System.err.print(" ");
				currWidth += w + 10;
			}
			System.err.print(word.word + " " + h + "," + w);
		}

		if (rowHeight > 0) {
			System.err.print(" " + rowHeight);
			totalHeight += rowHeight;
		}
		return totalHeight;
	}

	private int setupWordsAndReturnMaxCount(Scanner in, List<Word> words) {
		int n = in.nextInt();
		in.nextLine();

		int max = Integer.MIN_VALUE;


		for (int i = 0 ; i < n ; i++) {
			String str = in.next();
			int count = in.nextInt();

			if (max < count) {
				max = count;
			}

			words.add(new Word(str, count));
			in.nextLine();
		}
		return max;
	}

	private static class Word {
		private final String word;
		private final int count;

		public Word(String word, int count) {
			this.word = word;
			this.count = count;
		}

		public int size(int max) {
			double d = 8.0 + (40.0 * ((double)count - 4.0) / ((double)max - 4.0));

			return (int) Math.ceil(d);
		}

		public int width(int max) {
			double d = (9.0 * ((double)word.length()) * ((double)size(max))) / 16.0;

			return (int) Math.ceil(d);
		}

		@Override
		public String toString() {
			return "kattis.Word{" +
					"word='" + word + '\'' +
					", count=" + count +
					'}';
		}

	}
}
