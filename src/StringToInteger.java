public class StringToInteger {
    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            ++i;
        }
        boolean negative = false;
        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
            negative = str.charAt(i) == '-';
            ++i;
        }
        long result = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + str.charAt(i) - '0';
            ++i;
            if (!negative && result >= Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (negative && -result <= Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        if (negative) {
            result = -result;
        }
        return (int)result;
    }
}
