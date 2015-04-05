import java.util.Stack;

/*
 *  ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class ReversePolishNotation {

	public static String reversePolishNotation(String[] str) {
		String operator = "+-*/";

		Stack<String> stack = new Stack<>();

		for (String t : str) {
			if (!operator.contains(t))
				stack.push(t);
			else {
				int b = Integer.parseInt(stack.pop());
				int a = Integer.parseInt(stack.pop());
				int index = operator.indexOf(t);

				switch (index) {
				case 0:
					stack.push(String.valueOf(a + b));
					break;
				case 1:
					stack.push(String.valueOf(a - b));
					break;
				case 2:
					stack.push(String.valueOf(a * b));
					break;
				case 3:
					stack.push(String.valueOf(a / b));
					break;
				}
			}
		}
		return stack.pop();
	}
}
