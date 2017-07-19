public class ReverseInteger {
    public int reverse(int x) {
        long origin = x;
        if (origin < 0) {
            origin = -origin;
        }
        long result = 0;
        while (origin != 0) {
            result = result * 10 + origin % 10;
            origin /= 10;
        }
        if (x < 0) {
            result = -result;
        }
        return result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? 0 : (int)result;
    }
}
