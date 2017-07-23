public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        long a = dividend, b = divisor;
        a = a < 0 ? -a : a;
        b = b < 0 ? -b : b;
        int i = 0;
        while ((b << (i + 1)) <= a) {
            ++i;
        }
        long result = 0;
        while (i >= 0) {
            if ((b << i) <= a) {
                result += (long)1 << i;
                a -= b << i;
            }
            --i;
        }
        if (dividend < 0 == divisor < 0) {
            if (result > Integer.MAX_VALUE) {
                result = Integer.MAX_VALUE;
            }
        } else {
            result = -result;
            if (result < Integer.MIN_VALUE) {
                result = Integer.MIN_VALUE;
            }
        }
        return (int)result;
    }
}
