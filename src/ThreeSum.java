import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        while (i <= nums.length - 3) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    ++j;
                } else if (sum > 0) {
                    --k;
                } else {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    do {
                        ++j;
                    } while (j < k && nums[j] == nums[j - 1]);
                    do {
                        --k;
                    } while (j < k && nums[k] == nums[k + 1]);
                }
            }
            do {
                ++i;
            } while (i <= nums.length - 3 && nums[i] == nums[i - 1]);
        }
        return result;
    }
}
