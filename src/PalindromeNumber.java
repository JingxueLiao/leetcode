public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        long origin = x, reverse = 0;
        while (origin != 0) {
            reverse = reverse * 10 + origin % 10;
            origin /= 10;
        }
        return x == (int)reverse;
    }
}
