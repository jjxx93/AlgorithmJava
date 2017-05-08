package offer;

/**
 * 求二叉树的镜像
 * Created by jjxx9 on 2017/4/14.
 */
public class MirrorBinaryTree {
    /**
     * 递归地求树的镜像
     * @param root 树根
     */
    public static void getMirrorTreeRecursively(BinaryTreeNode root) {
        if (root == null || (root.left == null && root.right == null)) return;

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) getMirrorTreeRecursively(root.left);
        if (root.right != null) getMirrorTreeRecursively(root.right);
    }
}
