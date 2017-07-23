public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int i = 0, j = 0;
        while (j < nums.length) {
            nums[i++] = nums[j++];
            while (j < nums.length && nums[j] == nums[j - 1]) {
                ++j;
            }
        }
        return i;
    }
}
