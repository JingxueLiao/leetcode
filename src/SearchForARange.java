public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        return new int[]{lowerIndex(nums, target), upperIndex(nums, target)};
    }

    private int lowerIndex(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return begin < nums.length && nums[begin] == target ? begin : -1;
    }

    private int upperIndex(int[] nums, int target) {
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] <= target) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end >= 0 && nums[end] == target ? end : -1;
    }
}
