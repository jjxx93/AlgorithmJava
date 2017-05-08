package offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 找出二叉树中从根节点到叶节点和为某个值的路径。
 * Created by jjxx9 on 2017/5/2.
 */
public class SumPatch {
    public static void findSumPatch(BinaryTreeNode root, int exceptSum) {
        if (root == null) return;

        Deque<Integer> path = new ArrayDeque<>();
        int currentSum = 0;
        findPath(root, exceptSum, path, currentSum);
    }

    private static int findPath(BinaryTreeNode root, int exceptSum, Deque<Integer> path, int currentSum) {
        currentSum += root.val;
        path.push(root.val);

        if (currentSum == exceptSum && root.left == null && root.right == null) {       // 到达叶节点
            while (!path.isEmpty()) {
                System.out.print(path.pop() + " ");
            }
            System.out.println();
        }

        if (root.left != null) currentSum = findPath(root.left, exceptSum, path, currentSum);
        if (root.right != null) currentSum = findPath(root.right, exceptSum, path, currentSum);

        currentSum -= root.val;     // 返回父节点
        if (!path.isEmpty()) path.pop();
        return currentSum;
    }
}
