package fisikes.leetcode.linked_list;

import java.util.List;
import java.util.Stack;

public class RevertLinkedList {

  public static class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
      this.val = val;
    }

    public ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }


  public ListNode reverseList1(ListNode head) {

    Stack<ListNode> stack = new Stack<>();
    while (head != null) {
      stack.push(new ListNode(head.val));
      head = head.next;
    }

    ListNode prev = null;
    ListNode head2 = null;
    ListNode curr = null;
    while (!stack.isEmpty()) {
      prev = stack.pop();
      prev.next = null;

      // 初始化
      if (curr == null) {
        head2 = prev;
        curr = prev;
      } else {
        curr.next = prev;
        curr = prev;
      }
    }

    return head2;

  }

  // 将当前节点的next指向其父节点:
  // 当前节点无法获取父节点, 因此需要有个变量存储上一个节点信息prev.
  // 第一个节点的next为null, 因此先将prev赋值为null
  public ListNode reverseList(ListNode head) {

    // 上一个节点
    ListNode prev = null;
    // 当前节点
    ListNode curr = head;
    while (curr != null) {
      // 因为要修改当前节点的下一个节点; 因此先存下来next.
      ListNode next = curr.next;
      // 当前节点的next修改为前一个节点; 完成操作.
      curr.next = prev;

      // 进入下一轮
      prev = curr;
      curr = next;
    }

    return prev;
  }


}
