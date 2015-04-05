import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/*
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence 
 * where each word is a valid dictionary word. 
 * Return all such possible sentences. For example, 
 * given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"], 
 * the solution is ["cats and dog", "cat sand dog"]
 */
public class WordBreakAll {
	public static List<String> wordBreakAll(String str, Set<String> dict) {
		List<String> dp[] = new ArrayList[str.length() + 1];

		dp[0] = new ArrayList<String>();

		for (int i = 0; i < str.length(); i++) {
			if (dp[i] == null)
				continue;

			for (String s : dict) {
				int len = s.length();
				int end = i + len;

				if (end > str.length())
					continue;

				if (s.equals(str.substring(i, end))) {
					if (dp[end] == null) {
						dp[end] = new ArrayList<String>();
					}
					dp[end].add(s);
				}
			}
		}

		List<String> result = new ArrayList<String>();
		if (dp[str.length()] == null)
			return result;

		ArrayList<String> temp = new ArrayList<String>();
		dfs(dp, str.length(), result, temp);

		return result;
	}

	public static void dfs(List<String> dp[], int end, List<String> result,
			ArrayList<String> temp) {

		if (end <= 0) {
			String path = temp.get(temp.size() - 1);
			for (int i = temp.size() - 2; i >= 0; i--) {
				path += " " + temp.get(i);
			}

			result.add(path);
			return;
		}

		for (String s : dp[end]) {
			temp.add(s);
			dfs(dp, end - s.length(), result, temp);
			temp.remove(temp.size() - 1);
		}

	}
}
