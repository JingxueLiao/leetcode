public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null)
            return 0;
        int longest = 0;
        int head = 0;
        int[] lastIndex = new int[128];
        for (int i = 0; i < lastIndex.length; ++i) {
            lastIndex[i] = -1;
        }
        for (int tail = 0; tail < s.length(); ++tail) {
            if (lastIndex[s.charAt(tail)] >= head) {
                longest = Math.max(longest, tail - head);
                head = lastIndex[s.charAt(tail)] + 1;
            }
            lastIndex[s.charAt(tail)] = tail;
        }
        return Math.max(longest, s.length() - head);
    }
}
