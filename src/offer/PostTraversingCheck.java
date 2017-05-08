package offer;

/**
 * 后续遍历检查
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 假设输入的数组的任意两个数字都互不相同。
 * Created by jjxx9 on 2017/4/21.
 */
public class PostTraversingCheck {
    public boolean isBST(int [] sequence, int start, int end) {
        if (start >= end) return true;

        // 找出左子树根
        int i = start;
        int leftRoot = 0;
        for (; i < end; i++) {
            if (sequence[i] > sequence[end]) {
                leftRoot = i;
                break;
            }
        }
        if (i == end) return true;

        // 检查右边是否都小于根
        for (; i < end; i++) {
            if (sequence[i] < sequence[end]) return false;
        }

        // 检查左右边是否是后续遍历
        return isBST(sequence, start, leftRoot) && isBST(sequence, leftRoot + 1, end - 1);
    }

    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return isBST(sequence, 0, sequence.length - 1);
    }

    public static void main(String[] args) {
        int[] in = {4,8,6,12,16,14,10};
        System.out.println(new PostTraversingCheck().VerifySquenceOfBST(in));
    }
}
