package self;

public class HouseRobber1 {
    public static void main(String[] args) {
        System.out.println(new HouseRobber1().rob(new int[]{183,219,57,193,94,233,202,154,65,240,97,234,100,249,186,66,90,238,168,128,177,235,50,81,185,165,217,207,88,80,112,78,135,62,228,247,211}));
    }

    public int rob(int[] nums) {

        int max = 0;
        int len = nums.length;

        if (len == 0) {
            return 0;
        }

        if (len == 1) {
            return nums[0];
        }
        if (len == 2) {

            return Math.max(nums[0], nums[1]);
        }
        if (len == 3) {

            return Math.max(Math.max(nums[0], nums[1]), nums[2]);
        }
        for (int i = 0; i < len / 2; i++) {
            max = Math.max(hepler(i, i, len, nums[i], nums), max);
        }

        return max;
    }

    private int hepler(int i, int add, int len, int result, int[] nums) {


        int max = 0;

        for (int j = add + 2; j < len && (j + 1) % len != i; j++) {

            int level = nums[j] + result;

            int hepler = hepler(i, j, len, level, nums);

            max = Math.max(max, hepler);
        }

        return Math.max(max, result);

    }
}
