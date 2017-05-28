import java.util.Map;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if (nums == null) {
            return result;
        }
        Map<Integer, Integer> appeared = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; ++i) {
            if (appeared.containsKey(target - nums[i])) {
                result[0] = appeared.get(target - nums[i]);
                result[1] = i;
                break;
            }
            appeared.put(nums[i], i);
        }
        return result;
    }
}