public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < target) {
                begin = mid + 1;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                begin = mid;
                break;
            }
        }
        return begin;
    }
}
