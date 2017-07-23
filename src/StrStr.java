public class StrStr {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) {
            return -1;
        }
        if (needle.isEmpty()) {
            return 0;
        }
        int[] next = getNext(needle);
        int i = 0, j = 0, n = haystack.length(), m = needle.length();
        while (i < n && j < m) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
                if (j == -1) {
                    ++i;
                    j = 0;
                }
            }
        }
        return j == m ? i - m : -1;
    }

    private int[] getNext(String s) {
        int[] next = new int[s.length()];
        next[0] = -1;
        for (int i = 1; i < s.length(); ++i) {
            int j = next[i - 1];
            while (j != -1 && s.charAt(j) != s.charAt(i - 1)) {
                j = next[j];
            }
            next[i] = j + 1;
        }
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i) == s.charAt(next[i])) {
                next[i] = next[next[i]];
            }
        }
        return next;
    }
}
