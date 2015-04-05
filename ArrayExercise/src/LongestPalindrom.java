public class LongestPalindrom {

	public static String longestPalindromSubstring(String str) {
		if (str.isEmpty())
			return null;
		if (str.length() == 1)
			return str;

		String longestPali = str.substring(0, 1);

		for (int i = 0; i < str.length() - 1; i++) {

			// get longest palindrome with center of i
			String temp = helperPali(str, i, i);
			if (longestPali.length() < temp.length()) {
				longestPali = temp;
			}

			// get longest palindrome with center of i+1
			temp = helperPali(str, i, i + 1);
			if (longestPali.length() < temp.length()) {
				longestPali = temp;
			}
		}

		return longestPali;
	}

	// Find palindrom from center computed by begin and end index
	public static String helperPali(String str, int begin, int end) {
		while (begin >= 0 && end <= str.length()
				&& str.charAt(begin) == str.charAt(end)) {
			begin--;
			end++;
		}

		return str.substring(begin + 1, end);
	}
}
