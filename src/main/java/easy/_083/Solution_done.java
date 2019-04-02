package easy._083;

import structure.ListNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/10
 *     desc  :
 * </pre>
 */
public class Solution_done {
    public static void main(String[] args) {
        ListNode testData = ListNode.createTestData("[1,1,1,2,3,3,4,5,5,5,6]");
        ListNode listNode = deleteLoop(testData);
        ListNode.print(listNode);
    }

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;


        ListNode pre = head;
        ListNode next = head.next;

        if (next.val == pre.val) {
            head.next = head.next.next;
            deleteDuplicates(head);
        }
        ListNode newhead = head.next;
        deleteDuplicates(newhead);

        return head;

    }

    public static ListNode deleteLoop(ListNode head) {
        if (head == null)
            return null;

        if (head.next == null)
            return head;

        ListNode ll = head;
        while (ll.next != null) {
            if (ll.next.val == ll.val) {
                ll.next = ll.next.next;
            } else {
                ll = ll.next;
            }

        }


        return head;

    }
    /*
     原来解法
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution_done solution = new Solution_done();
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2]")));
        ListNode.print(solution.deleteDuplicates(ListNode.createTestData("[1,1,2,3,3]")));
    }*/

}
