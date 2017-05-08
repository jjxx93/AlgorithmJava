package offer;

import tree.BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 从上到下，从左到右依次打印二叉树的每个节点
 * Created by jjxx9 on 2017/5/2.
 */
public class PrintTreeByLayer {
    /**
     * 从上到下，从左到右依次打印二叉树的每个节点
     * 借助队列实现
     * @param root 二叉树根
     * @return 打印字符串
     */
    public static String printTreeByLayer(BinaryTreeNode root) {
        if (root == null) return "";

        StringBuilder outString = new StringBuilder();
        Deque<BinaryTreeNode> treeNodes = new ArrayDeque<>();
        treeNodes.offer(root);

        while(!treeNodes.isEmpty()) {
            BinaryTreeNode node = treeNodes.poll();
            outString.append(node.val);
            if (node.left != null) treeNodes.offer(node.left);
            if (node.right != null) treeNodes.offer(node.right);
        }

        return outString.toString();
    }
}
