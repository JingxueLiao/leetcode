public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder cp = new StringBuilder();
        boolean flag = true;
        int i = 0;
        while (flag) {
            for (int j = 0; j < strs.length; ++j) {
                if (i >= strs[j].length() || strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cp.append(strs[0].charAt(i));
            }
            ++i;
        }
        return cp.toString();
    }
}
