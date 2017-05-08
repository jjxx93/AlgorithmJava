package offer;

/**
 * Created by jjxx9 on 2017/3/8.
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

class BinaryTreeNode {
    int val = 0;
    BinaryTreeNode left = null;
    BinaryTreeNode right = null;

    public BinaryTreeNode(int val) {
        this.val = val;
    }

    public BinaryTreeNode(int val, BinaryTreeNode left, BinaryTreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
