package easy._100;


import structure.TreeNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/08
 *     desc  :
 * </pre>
 */
public class Solution_done {
    public static void main(String[] args) {
        Solution_done solution = new Solution_done();
        System.out.println(solution.isSameTree(
                TreeNode.createTestData("[1,2,2,10,null,3,null,3]"),
                TreeNode.createTestData("[1,2,2,10,1,3,null,3]"))
        );
        System.out.println(solution.isSameTree(
                TreeNode.createTestData("[1,2,2,3,null,3,null,3]"),
                TreeNode.createTestData("[1,2,2,null,3,null,null]"))
        );
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (q == null && p != null) {
            return false;
        }
        if (p == null && q == null)
            return true;
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
    public boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
