public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int result = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            int h = Math.min(height[i], height[j]);
            result = Math.max(result, h * (j - i));
            while (i < j && height[i] <= h) {
                ++i;
            }
            while (i < j && height[j] <= h) {
                --j;
            }
        }
        return result;
    }
}
