package easy._746;

public class Solution {
    public static void main(String[] args) {
        int[] ints = {12, 100000, 3000,2,10000,20000};
        System.out.println(new Solution().minCostClimbingStairs(ints));
    }

    public int minCostClimbingStairs(int[] cost) {
        if (cost.length <= 1) {
            return 0;
        }
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 2], dp[i - 1]) + cost[i];
        }
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
