package self;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class UniquePaths {

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println(new UniquePaths().uniquePaths(7, 3));
        System.out.println("时间:" + (System.currentTimeMillis() - l));
    }

    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int path = 0;
        Stack<node> stack = new Stack<>();
        stack.add(new node(0, 0));
        int[][] count = new int[n][m];
        Queue<node> queue
                =new LinkedList();
        queue.add(new node(0, 0));

        while (queue.size() > 0) {

            node pop = queue.poll();

            if ((pop.row == m - 2 && pop.col - 1 == n) || (pop.row == m - 1 && pop.col - 2 == n)) {
                path++;
            }

            if (pop.row + 1 < n) {
                queue.add(new node(pop.col, pop.row + 1));


            }

            if (pop.col + 1 < m) {
                queue.add(new node(pop.col + 1, pop.row));

            }


        }
        return path;
    }

    class node {
        private int col; //列
        private int row;  //行


        public node(int col, int down) {
            this.col = col;
            this.row = down;
        }
    }
}
