public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows <= 0) {
            return "";
        }
        StringBuffer[] rows = new StringBuffer[numRows];
        for (int i = 0; i < numRows; ++i) {
            rows[i] = new StringBuffer();
        }
        int i = 0;
        while (i < s.length()) {
            for (int j = 0; j < numRows && i < s.length(); ++j) {
                rows[j].append(s.charAt(i++));
            }
            for (int j = numRows - 2; j > 0 && i < s.length(); --j) {
                rows[j].append(s.charAt(i++));
            }
        }
        for (int j = 1; j < numRows; ++j) {
            rows[0].append(rows[j]);
        }
        return rows[0].toString();
    }
}
