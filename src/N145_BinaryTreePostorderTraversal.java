import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the postorder traversal of its nodes' values.
 *
 * For example:
 * Given binary tree {1,#,2,3},
 * 1
 *  \
 *   2
 *  /
 * 3
 * return [3,2,1].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 */
public class N145_BinaryTreePostorderTraversal {

    //Iteratively
    //by: richilee
    public List<Integer> postorderTraversal1(TreeNode root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null)  return result;
        TreeNode curr = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            result.addFirst(curr.val);
            if (curr.left != null )  stack.push(curr.left);
            if (curr.right !=null ) stack.push(curr.right);
        }
        return result;
    }


    //Recursive
    public List<Integer> postorderTraversal2(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> result = new ArrayList<>();
        result.addAll(postorderTraversal2(root.left));
        result.addAll(postorderTraversal2(root.right));
        result.add(root.val);
        return result;
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
