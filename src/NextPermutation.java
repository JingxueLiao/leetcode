public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            --i;
        }
        if (i != 0) {
            int j = i;
            while (j < nums.length && nums[j] > nums[i - 1]) {
                ++j;
            }
            swap(nums, i - 1, j - 1);
        }
        reverse(nums, i, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
