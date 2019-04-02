package easy._107;


import structure.TreeNode;

import java.util.*;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/09
 *     desc  :
 * </pre>
 */
public class Solution_done {


    public static ArrayList<Integer> levelOrderBottom(TreeNode node) {

        if (node == null)
            return new ArrayList<>(0);
        LinkedList<TreeNode> a = new LinkedList<>();
        Stack<TreeNode> stack = new Stack();
        a.add(node);
        stack.push(node);
        while (a.size() > 0) {
            TreeNode pop = a.pop();
            if (pop.right != null) {

                stack.push(pop.right);
                a.add(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
                a.add(pop.left);

            }
        }
        ArrayList<Integer> list = new ArrayList<>(stack.size());
        while (!stack.empty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);
        }
        return list;

    }

    public static void main(String[] args) {
        Solution_done solution = new Solution_done();
        System.out.println(solution.levelOrderBottom3(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
        System.out.println(solution.levelOrderBottom3(TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]")));
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        helper(list, root, 0);
        return list;
    }

    public List<List<Integer>> levelOrderBottom3(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new LinkedList();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.remove();
                sub.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            list.add(0, sub);
        }
        return list;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<>());
        }
        helper(list, root.left, level + 1);
        helper(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
