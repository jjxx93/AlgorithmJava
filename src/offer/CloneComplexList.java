package offer;

/**
 * 在复杂链表中，每个结点除了有一个next指针指向下一个结点外，还有一个sibling指针指向任意结点或者null。
 * Created by jjxx9 on 2017/5/5.
 */
class ComplexListNode {
    int value;
    ComplexListNode next;
    ComplexListNode sibling;

    public ComplexListNode(int value, ComplexListNode next, ComplexListNode sibling) {
        this.value = value;
        this.next = next;
        this.sibling = sibling;
    }
}

public class CloneComplexList {
    /**
     * 复制复杂链表
     * @param head 原链表头
     * @return 新链表头
     */
    public static ComplexListNode cloneComplexList(ComplexListNode head) {
        cloneNodes(head);
        return cloneSibling(head);
    }

    /**
     * 复制复杂链表中的每个结点，添加在原节点后
     * @param head 原链表头
     */
    private static void cloneNodes(ComplexListNode head) {
        ComplexListNode tempNode = head;
        while (tempNode != null) {
            ComplexListNode newNode = new ComplexListNode(tempNode.value, tempNode.next, tempNode.sibling);
            tempNode.next = newNode;

            tempNode = newNode.next;    // 后移一位
        }
    }

    /**
     * 复制sibling结点，返回新链表头
     * @param head 原链表头
     * @return 新链表头
     */
    private static ComplexListNode cloneSibling(ComplexListNode head) {
        if (head == null) return null;
        ComplexListNode newHead = head.next;    // 新链表头
        if (newHead.sibling != null) newHead.sibling = newHead.sibling.next;

        if (newHead.next == null) return newHead;
        else {
            ComplexListNode tempNewListNode = newHead;
            ComplexListNode tempNode = newHead.next;
            while (tempNode != null) {
                ComplexListNode cloneNode = tempNode.next;
                tempNewListNode.next = cloneNode;
                if (cloneNode.sibling != null) cloneNode.sibling = cloneNode.sibling.next;

                tempNode = cloneNode.next;  // 后移一位
                tempNewListNode = cloneNode;
            }
        }
        return newHead;
    }

}
