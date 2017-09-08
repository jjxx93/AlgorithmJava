package offer;

/**
 * 检查树1是否包含树2。思路：
 * 1. 在树1中找到和树2根节点相同的节点R；
 * 2. 判断树1中以R为根节点的子树是否包含树2
 * Created by jjxx9 on 2017/4/13.
 */
public class Tree1HasTree_02 {
    /**
     * 寻找相同根节点
     */
    public static boolean hasSubtree(BinaryTreeNode treeRoot1, BinaryTreeNode treeRoot2) {
        boolean result = false;

        if (treeRoot1 != null && treeRoot2 != null) {
            if (treeRoot1.val == treeRoot2.val) result = doseTree1HasTree2(treeRoot1, treeRoot2);
            if (!result) result = hasSubtree(treeRoot1.left, treeRoot2);
            if (!result) result = hasSubtree(treeRoot1.right, treeRoot2);
        }

        return result;
    }

    /**
     * 比较两树
     */
    private static boolean doseTree1HasTree2(BinaryTreeNode treeRoot1, BinaryTreeNode treeRoot2) {
        if (treeRoot2 == null) return true;
        if (treeRoot1 == null) return false;

        if (treeRoot1.val != treeRoot2.val) return false;
        return doseTree1HasTree2(treeRoot1.left, treeRoot2.left) && doseTree1HasTree2(treeRoot1.right, treeRoot2.right);
    }
}
