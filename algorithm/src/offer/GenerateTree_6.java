package offer;

/**
 * 根据前序和中序建立二叉树
 *
 * Created by jjxx9 on 2017/8/31.
 */
public class GenerateTree_6 {
    private static class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;

        TreeNode(int value) {
            this.value = value;
        }
    }

    /**
     * 根据前序序列和中序序列建立二叉树
     *
     * @param preOrder 前序序列
     * @param inOrder  中序序列
     * @return 二叉树根
     */
    public static TreeNode GenerateTreeByPreOrderAndInOrder (int[] preOrder, int[] inOrder) {
        if (preOrder.length != inOrder.length) {
            return null;
        }
        return generateSubTreeByPreOrderAndInOrder(preOrder,0,preOrder.length - 1,
            inOrder,0,inOrder.length - 1);
    }

    /**
     * 根据部分前序序列和部分中序序列建立子二叉树
     *
     * @param preOrder 部分前序序列
     * @param inOrder  部分中序序列
     * @return 子二叉树根
     */
    private static TreeNode generateSubTreeByPreOrderAndInOrder (int [] preOrder, int startPreIndex, int endPreIndex,
                                                           int [] inOrder, int startInIndex, int endInIndex) {
        if ((startPreIndex > endPreIndex) || (startInIndex > endInIndex)) {
            return null;
        }

        TreeNode root = new TreeNode(preOrder[startInIndex]);

        for (int i = startInIndex; i < endInIndex; i++) {
            if (inOrder[i] == preOrder[startInIndex]) {     // 找出中序遍历中根节点位置
                // 构建左子树
                root.left = generateSubTreeByPreOrderAndInOrder(preOrder, startPreIndex + 1,
                    endPreIndex + i - startInIndex, inOrder, startInIndex, i - 1);
                // 构建右子树
                root.right = generateSubTreeByPreOrderAndInOrder(preOrder, i - startPreIndex + 1,
                    endPreIndex + i - startInIndex, inOrder, i + 1, endInIndex);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = {0,2,4,7,3,5,6,9};
        int[] inOrder =  {4,7,2,0,5,3,9,6};

        GenerateTree_6.GenerateTreeByPreOrderAndInOrder(preOrder, inOrder);
    }
}
