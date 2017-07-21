import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            for (int j = i + 1; j < nums.length - 2; ++j) {
                int k = j + 1, l = nums.length - 1;
                while (k < l) {
                    int sum = nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        ++k;
                    } else if (sum > target) {
                        --l;
                    } else {
                        result.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                        do {
                            ++k;
                        } while (k < l && nums[k] == nums[k - 1]);
                        do {
                            --l;
                        } while (k < l && nums[l] == nums[l + 1]);
                    }
                }
                while (j < nums.length - 3 && nums[j] == nums[j + 1]) {
                    ++j;
                }
            }
            while (i < nums.length - 4 && nums[i] == nums[i + 1]) {
                ++i;
            }
        }
        return result;
    }
}
