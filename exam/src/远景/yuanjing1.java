package 远景;

/**
 * validate-binary-search-tree
 *
 * Created by jjxx9 on 2017/9/6.
 */
import java.util.ArrayDeque;
import java.util.Deque;

class TreeNode {
  int val;
 TreeNode left;
 TreeNode right;
  TreeNode(int x) { val = x; }
}


public class yuanjing1 {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curNode = root;
        TreeNode preNode = null;
        while (!stack.isEmpty() || curNode != null) {
            if (curNode == null) {
                curNode = stack.pop();
                if (preNode != null && preNode.val >= curNode.val) {
                    return false;
                }
                preNode = curNode;
                curNode = curNode.right;
            } else {
                stack.push(curNode);
                curNode = curNode.left;
            }
        }
        return true;
    }

    private static boolean checkRecursively(TreeNode root, int lowerLimit, int upperLimit) {
        return root == null
                || root.val > lowerLimit && root.val < upperLimit
                && checkRecursively(root.left, lowerLimit, root.val)
                && checkRecursively(root.right, root.val, upperLimit);
    }
}
