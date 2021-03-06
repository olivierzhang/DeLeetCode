/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */
public class N108_ConvertSortedArrayToBinarySearchTree {

    //by: jiaming2
    public TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0) {
            return null;
        }
        TreeNode head = helper(num, 0, num.length - 1);
        return head;
    }

    public TreeNode helper(int[] num, int low, int high) {
        if (low > high) { // Done
            return null;
        }
        int mid = (low + high) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = helper(num, low, mid - 1);
        node.right = helper(num, mid + 1, high);
        return node;
    }

    public class TreeNode {
            int val;
             TreeNode left;
             TreeNode right;
             TreeNode(int x) { val = x; }
         }

}
