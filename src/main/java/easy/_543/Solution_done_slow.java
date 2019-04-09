package easy._543;


import structure.TreeNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/13
 *     desc  :
 * </pre>
 */
public class Solution {

    int max = 0;

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.di(TreeNode.createTestData("[4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,2,6,5,null,9,null,null,-1,-4,null,null,null,-2]")));
    }

    public int diameterOfBinaryTree3(TreeNode root) {

        if (root == null)
            return 0;

        int left = diameterOfBinaryTree3(root.left);

        int right = diameterOfBinaryTree3(root.right);

        return Math.max(left, right) + 1;


    }


    public int diameterOfBinaryTree(TreeNode root) {

        if (root == null) {
            return max;
        }

        max = Math.max(di(root), max);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return max;

    }

    public int di(TreeNode root) {


        int left = 0;

        if (root.left != null) {
            left = helper(root.left, 1);
        }
        int right = 0;

        if (root.right != null) {
            right = helper(root.right, 1);
        }


        return left + right;
    }

    public int helper(TreeNode node, int deep) {
        int right = deep;
        int left = deep;
        if (node.left != null) {
            left = helper(node.left, ++left);
        }
        if (node.right != null) {
            right = helper(node.right, ++right);
        }
        return Math.max(left, right);
    }

    public int diameterOfBinaryTree2(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        if (l + r > max) max = l + r;
        return Math.max(l, r) + 1;
    }
}
