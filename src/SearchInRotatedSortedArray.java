public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        int result = -1;
        int begin = 0, end = nums.length - 1;
        while (begin <= end) {
            int mid = begin + (end - begin) / 2;
            if (nums[mid] < target) {
                if (nums[begin] > nums[mid] && target >= nums[begin]) {
                    end = mid - 1;
                } else {
                    begin = mid + 1;
                }
            } else if (nums[mid] > target) {
                if (nums[mid] > nums[end] && target <= nums[end]) {
                    begin = mid + 1;
                } else {
                    end = mid - 1;
                }
            } else {
                result = mid;
                break;
            }
        }
        return result;
    }
}
