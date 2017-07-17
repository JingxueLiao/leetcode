public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] t = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length(); ++i) {
            t[2 * i] = '#';
            t[2 * i + 1] = s.charAt(i);
        }
        t[t.length - 1] = '#';
        int longest = 0, furthest = 0;
        int[] lengths = new int[t.length];
        for (int i = 0; i < t.length; ++i) {
            lengths[i] = 0;
            if (i <= furthest + lengths[furthest]) {
                lengths[i] = Math.min(lengths[2 * furthest - i], furthest + lengths[furthest] - i);
            }
            while (i - lengths[i] > 0 && i + lengths[i] < t.length - 1 && t[i - lengths[i] - 1] == t[i + lengths[i] + 1]) {
                ++lengths[i];
            }
            if (lengths[i] > lengths[longest]) {
                longest = i;
            }
            if (i + lengths[i] > furthest + lengths[furthest]) {
                furthest = i;
            }
        }
        return s.substring((longest - lengths[longest]) / 2, (longest + lengths[longest]) / 2);
    }
}
