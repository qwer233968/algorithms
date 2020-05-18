package algorithms.leetcode;

public class LinkNodeDemo {
    /**
     * K 个一组翻转链表
     *给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
     * k 是一个正整数，它的值小于或等于链表的长度。
     * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     * 示例：
     * 给你这个链表：1->2->3->4->5
     * 当 k = 2 时，应当返回: 2->1->4->3->5
     * 当 k = 3 时，应当返回: 3->2->1->4->5
     *
     * 你的算法只能使用常数的额外空间。
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * @param head
     * @param k
     * @return 2 1 3 4 5
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        //递归终止条件，当head为null时中止递归
        if (head == null) {
            return null;
        }
        //根据k寻找待翻转链表的尾
        ListNode end = head;
        for (int i = 0; i < k - 1; i++) {
            end = end.next;
            if (end == null) {
                return head;
            }
        }
        //保存好下次翻转的链表的头
        ListNode nextListNode = end.next;
        //翻转[start , end]范围中的链表，并返回头节点
        ListNode newHead = reverseListNode(head, end);
        //此时head已经变成了链表的尾节点
        //本次翻转后的链表的尾节点连接上下一个待翻转链表的头节点，递归实现
        head.next = reverseKGroup(nextListNode, k);
        return newHead;
    }

    private ListNode reverseListNode(ListNode start, ListNode end) {
        ListNode tmp = null;
        while (tmp != end) {
            ListNode next = start.next;
            start.next = tmp;
            tmp = start;
            start = next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        ListNode test = new ListNode(1);
        test.next = new ListNode(2);
        test.next.next = new ListNode(3);
        test.next.next.next = new ListNode(4);
        test.next.next.next.next = new ListNode(5);
        LinkNodeDemo demo = new LinkNodeDemo();
        demo.reverseKGroup(test,2);
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}