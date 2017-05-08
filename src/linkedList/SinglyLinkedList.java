package linkedList;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 单链表结构
 * Created by jjxx9 on 2017/4/9.
 */
class SinglyLinkedList {
    class ListNode {
        int value;
        ListNode next;

        ListNode(int value) {
            this.value = value;
        }

        ListNode(int value, ListNode next) {
            this.value = value;
            this.next  = next;
        }
    }

    private ListNode head;

    public SinglyLinkedList(int value) {
        this.head = new ListNode(value);
    }

    /**
     * 向链表中添加元素
     * @param value 新值
     */
    public void addToTail(int value) {
        ListNode newNode = new ListNode(value);

        if (head == null) {
            head = newNode;
        } else {
            ListNode tempNode = head;
            while (tempNode.next != null) tempNode = tempNode.next;
            tempNode.next = newNode;
        }
    }

    /**
     * 删除结点
     * @param value 待删除值
     * @return 删除成功与否
     */
    public boolean removeNode(int value) {
        if (head == null) return false;

        if (head.value == value) {
            head = head.next;
            return true;
        } else {
            ListNode tempNode = head;
            while (tempNode.next != null && tempNode.next.value != value) tempNode = tempNode.next;
            if (tempNode.next != null) {
                tempNode.next = tempNode.next.next;
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 顺序遍历链表
     * @return 遍历结果
     */
    public String showList() {
        StringBuilder stringOut = new StringBuilder();
        ListNode tempNode = head;

        while (tempNode != null) {
            stringOut.append(tempNode.value);
            stringOut.append("-->");
            tempNode = tempNode.next;
        }

        if (stringOut.lastIndexOf("-->") > 0) stringOut.delete(stringOut.length() - 3, stringOut.length());
        return stringOut.toString();
    }

    /**
     * 逆序遍历链表
     * @return 遍历结果
     */
    public String showListReversibly() {
        Deque<Integer> valueDeque = new ArrayDeque<>();

        StringBuilder stringOut = new StringBuilder();
        ListNode tempNode = head;

        while (tempNode != null) {
            valueDeque.push(tempNode.value);
            tempNode = tempNode.next;
        }

        while (!valueDeque.isEmpty()) {
            stringOut.append(valueDeque.pop());
            stringOut.append("-->");
        }

        if (stringOut.lastIndexOf("-->") > 0) stringOut.delete(stringOut.length() - 3, stringOut.length());
        return stringOut.toString();
    }

    public static void main(String[] args) {
        SinglyLinkedList linkedList = new SinglyLinkedList(1);

        linkedList.addToTail(2);
        linkedList.addToTail(3);
        linkedList.addToTail(4);
        linkedList.addToTail(5);

        System.out.println(linkedList.showList());
        System.out.println(linkedList.showListReversibly());
    }
}


