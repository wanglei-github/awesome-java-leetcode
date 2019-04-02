package easy._088;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/06/01
 *     desc  :
 * </pre>
 */
public class Solution_done {


    public static void merge(ArrayList<Integer> nums1, int m, ArrayList<Integer> nums2, int n) {
        int start = 0;
        flag:
        for (int i = 0; i < nums2.size(); i++) {

            tt:
            for (int j = start; j < m; j++) {

                if (j + 1 == nums1.size()) {

                    if (nums1.get(nums1.size() - 1) < nums2.get(i)) {
                        nums1.add(nums1.size(), nums2.get(i));
                    } else {
                        nums1.add(j, nums2.get(i));
                    }
                    break tt;

                }
                if (nums1.get(j) <= nums2.get(i) && nums2.get(i) < nums1.get(j + 1)) {
                    nums1.add(j + 1, nums2.get(i));
                    start = j + 1;
                    continue flag;
                }
                if(nums2.get(i)<nums1.get(j)){
                    nums1.add(j, nums2.get(i));
                    start = j + 1;
                    continue flag;
                }
            }

        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m-- + n-- - 1;
        while (m >= 0 && n >= 0)
            nums1[p--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        while (n >= 0)
            nums1[p--] = nums2[n--];
    }

    public static void main(String[] args) {
        Solution_done solution = new Solution_done();
        int[] nums1 = new int[10];
        for (int i = 0; i <=5; ++i) {
            nums1[i] = 10 * i+10;
        }
        int[] nums2 = new int[5];
        for (int i = 0; i < 5; ++i) {
            nums2[i] =6;
        }
        solution.merge(nums1, 5, nums2, 5);
        System.out.println(Arrays.toString(nums1));
    }
}
