package easy._001;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/21
 *     desc  :
 * </pre>
 */
public class Solution {
//    public int[] twoSum(int[] nums, int target) {
//        for (int i = 0; i < nums.length; ++i) {
//            for (int j = i + 1; j < nums.length; ++j) {
//                if (nums[i] + nums[j] == target) {
//                    return new int[]{i, j};
//                }
//            }
//        }
//        return null;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 18;
        System.out.println(Arrays.toString(twoSum2(nums, target)));
    }

    public static int[] twoSum2(int[] sums, int targert) {
        for (int i = 0; i < sums.length; i++) {
            int first = sums[i];
            for (int j = i + 1; j < sums.length; j++) {
                int result = first + sums[j];
                if (result == targert)
                    return new int[]{i, j};
            }
        }
        return null;
    }

    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
