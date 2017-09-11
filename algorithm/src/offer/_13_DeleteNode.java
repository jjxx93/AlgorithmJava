package offer;

/**
 * 给定一个单向链表的头指针和一个结点指针，在O(1)时间删除该节点。
 *
 * Created by 熊佳新 on 2017/9/10.
 */
class ListNode{
    int val;
    ListNode next;
}

public class _13_DeleteNode {
    static ListNode deleteNode(ListNode head, ListNode target) {
        if (head == null || target == null) {
            return null;
        }

        if (target.next == null) {  // 待删除结点是尾节点
            ListNode tempNode = head;
            while (tempNode.next != target) {
                tempNode = tempNode.next;
            }

            tempNode.next = null;
        } else if (head == target) {    // 待删除结点是头节点
            head = null;
        } else {
            ListNode nextNode = target.next;
            target.val = nextNode.val;
            target.next = nextNode.next;
        }

        return head;
    }
}
