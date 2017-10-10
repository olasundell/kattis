import javax.script.ScriptException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * TODO write documentation
 */
public class FourThought {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new FourThought().solve(in));
	}

	public String solve(Scanner in) {
		Map<Integer, String> map = null;
//		try {
//			map = precalc();
//		} catch (ScriptException e) {
//			throw new IllegalStateException();
//		}
		List<String> results = new ArrayList<>();

		int n = in.nextInt();

		for (int i = 0 ; i < n ; i++) {
			int r = in.nextInt();
			if (map.containsKey(r)) {
				results.add(map.get(r) + " = " + r);
			} else {
				results.add("no solution");
			}
		}

		return results.stream().collect(Collectors.joining("\n"));
	}

//	private final char[] operators = {'+', '-', '*', '/'};

//	private Map<Integer,String> precalc() throws ScriptException {
////		ScriptEngineManager mgr = new ScriptEngineManager();
////		ScriptEngine engine = mgr.getEngineByName("JavaScript");
//
//		Map<Integer, String> expressions = new HashMap<>();
//
//		for (Operator c1: Operator.values()) {
//			for (Operator c2 : Operator.values()) {
//				for (Operator c3 : Operator.values()) {
//					final char[] script = { '4', c1, '4', c2, '4', c3, '4' };
////					Integer result = (Integer) engine.eval("(" + script + ") | 0");
//					int result = eval(script);
//					expressions.put(result, String.valueOf(script));
//				}
//			}
//		}
//
//		return expressions;
//	}

//	private Map<Integer, String> createExpessions() {
//		for (Operator o1: Operator.values()) {
//			for (Operator o2: Operator.values()) {
//				for (Operator o3: Operator.values()) {
//					Expression expression = new Expression(Arrays.asList(o1, o2, o3));
//				}
//			}
//		}
//	}

	class Expression {
		final Deque<Operator> operators = new ArrayDeque<>();
		final Deque<Integer> values = new ArrayDeque<>();

		Expression(List<Operator> operators) {
			this.operators.addAll(operators);
			values.addAll(Arrays.asList(4, 4, 4, 4));
		}

		Expression(Expression e) {

		}
	}

	private int eval(Expression expression) {
		return 0;
	}

	/*

	 */
	private int eval(char[] script) {
		Deque<Double> values = new ArrayDeque<>();
		Deque<Operator> operators = new ArrayDeque<>();

		Deque<Character> chars = new ArrayDeque<>();

		for (char c: script) {
			chars.add(c);
		}

		while (!chars.isEmpty()) {
			char c = chars.pollFirst();

			if (c == '4') {
				values.add(4.0);
			} else {
				// operator, poll first and continue
				chars.pollFirst();
				values.add(4.0);

				Operator next = Operator.NONE;

				if (!chars.isEmpty()) {
					next = findOperator(chars.peek());
				}

				Operator current = findOperator(c);
				if (current.prio < next.prio) {
					// TODO do stuff
					operators.push(current);
					popAndOperate(values, operators);
				}
			}
		}

		return (int) Math.round(Math.floor(values.getFirst()));
	}

	private void popAndOperate(Deque<Double> values, Deque<Operator> operators) {
		Operator op = operators.pop();
		values.push(op.operate(values.pop(), values.pop()));
	}

	private Operator findOperator(char c) {
		switch (c) {
			case '+':
				return Operator.ADD;
			case '-':
				return Operator.SUB;
			case '*':
				return Operator.MUL;
			case '/':
				return Operator.DIV;
		}
		return Operator.NONE;
	}

	enum Operator {
		MUL(0),
		DIV(0),
		ADD(1),
		SUB(1),
		NONE(2);

		int prio;

		Operator(int prio) {
			this.prio = prio;
		}

		double operate(double a, double b) {
			switch (this) {
				case ADD:
					return a + b;
				case SUB:
					return a - b;
				case MUL:
					return a * b;
				case DIV:
					return a / b;
			}
			return 0;
		}
	}
}
