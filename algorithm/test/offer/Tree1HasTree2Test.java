package offer;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by jjxx9 on 2017/4/14.
 */
public class Tree1HasTree2Test {
    @Test
    public void hasSubtree() throws Exception {
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node7 = new BinaryTreeNode(7);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node7);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        BinaryTreeNode node8 = new BinaryTreeNode(8, node9, node2);
        BinaryTreeNode node72 = new BinaryTreeNode(7);
        BinaryTreeNode root1  = new BinaryTreeNode(8, node8, node72);

        BinaryTreeNode root2 = new BinaryTreeNode(8, node9, node2);
        assertTrue(_02_Tree1HasTree.hasSubtree(root1, root2));
        assertFalse(_02_Tree1HasTree.hasSubtree(null, root2));
        assertFalse(_02_Tree1HasTree.hasSubtree(root1, null));
    }
}