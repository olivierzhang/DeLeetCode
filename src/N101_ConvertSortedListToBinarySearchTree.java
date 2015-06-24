/**
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class N101_ConvertSortedListToBinarySearchTree {

    //by: delongyang
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }

        ListNode mid = head;
        ListNode pre_mid = null;
        ListNode fast = head;

        while (true) {
            if (fast != null && fast.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
            pre_mid = mid;
            mid = mid.next;
        }
        if (pre_mid != null)
            pre_mid.next = null;


        TreeNode root = new TreeNode(mid.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);

        return root;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
