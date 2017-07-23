public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }
        int i = 0, j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                ++j;
            } else {
                nums[i++] = nums[j++];
            }
        }
        return i;
    }
}
