package self;

import java.util.Stack;

public class UniquePaths {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(new UniquePaths().uniquePaths(7, 3));
        System.out.println("时间:" + (System.currentTimeMillis() - l));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 1;
                else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }


    public int first_commit_record(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int path = 0;
        Stack<node> stack = new Stack<>();
        stack.add(new node(0, 0));
        while (stack.size() > 0) {
            node pop = stack.pop();
            if (pop.down == n - 1 && pop.right == m - 1) {
                path++;
                continue;
            }
            if (pop.right + 1 < m) {
                stack.push(new node(pop.right + 1, pop.down));
            }
            if (pop.down + 1 < n) {
                stack.push(new node(pop.right, pop.down + 1));
            }

        }
        return path;
    }


    class node {
        private int right; //列
        private int down;  //行

        public node(int right, int down) {
            this.right = right;
            this.down = down;
        }
    }
}
