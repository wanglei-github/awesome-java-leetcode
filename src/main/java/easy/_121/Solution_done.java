package easy._121;


/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/11
 *     desc  :
 * </pre>
 */
public class Solution_done {
    public static void main(String[] args) {
        Solution_done solution = new Solution_done();
        System.out.println(solution.maxProfit2(new int[]{2, 1, 4}));
        System.out.println(solution.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit2(new int[]{7, 6, 4, 3, 1}));
    }


    public int maxProfit(int[] prices) {
        int max = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) minPrice = prices[i];
            int delta = prices[i] - minPrice;
            if (delta > max) max = delta;
        }
        return max;
    }

    public int maxProfit3(int[] prices) {
        int len = prices.length;
        if (len <= 1) {
            return 0;
        }
        if (len == 2) {
            int re = prices[1] - prices[0];
            return re > 0 ? re : 0;
        }
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(prices[j] - prices[i], max);
            }
        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int[] dp2 = new int[prices.length];
        dp2[0] = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            dp2[i] = Math.min(dp2[i - 1], prices[i]);
            max = Math.max(prices[i] - dp2[i], max);
        }


        return max;
    }
}
