import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 *
 * Calling next() will return the next smallest number in the BST.
 *
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 *
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

public class N173_BinarySearchTreeIterator {

    //by: scott
    public class BSTIterator {
        Stack<TreeNode> stack =  null ;
        TreeNode current = null ;

        public BSTIterator(TreeNode root) {
            current = root;
            stack = new Stack<> ();
        }

        /** @return whether we have a next smallest number */
        public boolean hasNext() {
            return !stack.isEmpty() || current != null;
        }

        /** @return the next smallest number */
        public int next() {
            while (current != null) {
                stack.push(current);
                current = current.left ;
            }
            TreeNode t = stack.pop() ;
            current = t.right ;
            return t.val ;
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
}
