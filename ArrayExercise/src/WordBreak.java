import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into 
 * a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".
 */
public class WordBreak {

	/*
	 * By using recursion approach
	 */
	public static boolean mathcesWithRecursion(String str, Set<String> dict,
			int start) {

		if (start == str.length())
			return true;

		for (String s : dict) {
			int len = s.length();
			int end = start + len;

			if (end > str.length())
				continue;

			if (s.equals(str.substring(start, end))) {
				if (mathcesWithRecursion(str, dict, end)) {
					return true;
				}
			}
		}

		return false;
	}

	/*
	 * regular expression (leet|code)*
	 */
	public static boolean patternApproch(String str, Set<String> dict) {
		StringBuilder sb = new StringBuilder("(");

		for (String s : dict) {
			sb.append(s + "|");
		}

		String pattern = sb.toString().substring(0, sb.length() - 1) + ")*";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);

		if (m.matches()) {
			return true;
		}

		return false;
	}
}
