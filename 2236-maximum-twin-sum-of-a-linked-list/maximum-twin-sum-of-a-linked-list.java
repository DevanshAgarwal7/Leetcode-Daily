/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int pairSum(ListNode head) {
        ListNode midNode = getMidNode(head);
        ListNode reversedSecondHalfListHead = reverse(midNode);
        int max = Integer.MIN_VALUE;
        while(head != null && reversedSecondHalfListHead != null){
            max = Math.max(max, (head.val + reversedSecondHalfListHead.val));
            head = head.next;
            reversedSecondHalfListHead = reversedSecondHalfListHead.next;
        }
        return max;
        
    }

    private ListNode getMidNode(final ListNode head){
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode node = slow.next;
        slow.next = null;
        return node;
    }

    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    private void print(ListNode head){
        while(head != null){
            System.out.println(head.val + " -> ");
            head = head.next;
        }
    }
}