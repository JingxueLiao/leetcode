public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int longest = 0;
        int[] lengths = new int[s.length()];
        lengths[0] = 0;
        for (int i = 1; i < s.length(); ++i) {
            int j = i - 1 - lengths[i - 1];
            if (s.charAt(i) == '(' || j < 0 || s.charAt(j) != '(') {
                lengths[i] = 0;
            } else {
                lengths[i] = lengths[i - 1] + 2 + (j > 0 ? lengths[j - 1] : 0);
                longest = Math.max(longest, lengths[i]);
            }
        }
        return longest;
    }
}
