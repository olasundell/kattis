import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

/**
 * TODO write documentation
 */
public class Vending {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new Vending().solve(in));
	}

	public String solve(Scanner in) {
		int n = in.nextInt();
		in.nextLine();
		List<Product> products = new ArrayList<>();
		Map<Integer, PriorityQueue<Product>> positions = new HashMap<>();

		for (int i = 0 ; i < n ; i++) {
			final String[] s = in.nextLine().split(" ");
			final Product e = new Product(Integer.valueOf(s[0]), Integer.valueOf(s[1]), Integer.valueOf(s[2]), Integer.valueOf(s[3]));
			products.add(e);
			if (!positions.containsKey(e.realPos)) {
				positions.put(e.realPos, new PriorityQueue<>(Comparator.comparing(p -> p.payPrice)));
			}
			positions.get(e.realPos).add(e);
		}

//		final AtomicLong sum = new AtomicLong(0);
		final long[] sum = new long[1];
		sum[0] = 0;

		positions.forEach((realPos, prods) -> {
			final Product product = products.get(realPos - 1);
			if (!prods.isEmpty() && prods.peek().payPrice < product.marketPrice) {
				final long i = product.marketPrice - prods.peek().payPrice;
				final long delta = i * product.stock;
				sum[0] += delta;
//				sum.addAndGet(delta);
			}
		});

		return String.valueOf(sum[0]);
	}

	class Product {
		final int realPos;
		final int payPrice;
		final int marketPrice;
		final int stock;

		public Product(int realPos, int payPrice, int marketPrice, int stock) {
			this.realPos = realPos;
			this.payPrice = payPrice;
			this.marketPrice = marketPrice;
			this.stock = stock;
		}
	}
}
