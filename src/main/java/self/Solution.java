package self;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {

    public static void main(String[] args) {

        System.out.println(new Solution().lengthOfLongestSubstring("aussdfer"));



        System.out.println(new int['a']);
        String a="123";
        char[] chars = a.toCharArray();

        int[] parent = new int[5];
        for (int i = 0; i < 5; i++) {
            parent[i] = i;


        }


//        System.out.println(new Solution().threeSum(new int[]{-4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6}));
//        System.out.println(new Solution().search(new int[]{1}, 0));
//        System.out.println(new Solution().findCircleNum(new int[][]{
//
//                {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}
//
//        }));
    }


    public int findCircleNum2(int[][] M) {

        if (M == null && M.length == 0)
            return 0;
        int n = M.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        //如果dfs大于0，说明有未遍历的结点
        //只需要遍历所有结点
        for (int i = 0; i < n; i++)
            if (dfs(M, i, visited) > 0)
                count++;
        return count;

    }

    private int dfs(int[][] mat, int i, boolean[] visited) {
        if (visited[i])
            return 0;
        visited[i] = true;
        int count = 1;
        for (int j = 0; j < visited.length; j++)
            if (i != j && mat[i][j] == 1)
                count += dfs(mat, j, visited);
        return count;
    }


    public int findCircleNum(int[][] M) {
        int res = 0;
        int[] visited = new int[M.length];
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                res++;
                dfs(M, visited, i);
            }
        }
        return res;
    }

    private void dfs(int[][] M, int[] visited, int i) {
        visited[i] = 1;
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                dfs(M, visited, j);
            }

        }
    }


    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;

        int mid = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                mid = i - 1;
                break;
            }
        }
        if (nums[mid] == target) {
            return mid;
        }
        if (nums.length == 1) {
            return -1;
        }
        int result = find(0, mid - 1, target, nums);
        return result != -1 ? result : find(mid + 1, nums.length - 1, target, nums);

    }

    public int find(int start, int end, int target, int[] nums) {
        int mid = (end - start) / 2 + start;
        if (target == nums[mid]) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (target < nums[mid]) {
            return find(start, mid - 1, target, nums);
        } else if (target > nums[mid]) {
            return find(mid + 1, end, target, nums);
        }
        return -1;
    }


    public List<List<Integer>> threeSum(int[] nums) {

        HashSet<Integer> set = new HashSet<Integer>();

        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums.length - 1; j > i; j--) {
                flag:
                for (int m = j - 1; m > i; m--) {
                    if (nums[i] + nums[j] + nums[m] == 0) {
                        if (set.size() == 0) {
                            set.add(nums[i]);
                            set.add(nums[m]);
                            set.add(nums[j]);
                        } else {
                            int size = set.size();
                            set.add(nums[i]);
                            set.add(nums[m]);
                            set.add(nums[j]);
                            if (set.size() - size == 0) {
                                continue flag;
                            }
                        }


                        List<Integer> integers = new ArrayList<Integer>();
                        integers.add(nums[i]);
                        integers.add(nums[j]);
                        integers.add(nums[m]);

                        lists.add(integers);
                    }
                }
            }

        }
        return lists;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0 ){
            return 0;
        }
        if(s.trim().length() ==0){
            return 1;
        }
        int reslut = 1;
        flag:
        for (int i = 0; i < s.length(); i++) {
            int sum = 1;
            String s1 = Character.toString(s.charAt(i));
            for (int j = i + 1; j < s.length(); j++) {
                String s2 = Character.toString(s.charAt(j));
                if (!s1.equals(s2)) {
                    sum++;
                    if(j+1==s.length()){
                        reslut = Math.max(reslut, sum);
                    }
                    continue;
                }
                reslut = Math.max(reslut, sum);
                continue flag;
            }
        }
        return reslut;

    }

    class ListNode {
        String val;
        ListNode next;

        ListNode(String x) {
            val = x;
        }
    }

}
