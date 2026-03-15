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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;
        while(curr != null){
            list.add(curr);
            curr = curr.next;
        }
        int left = 0;
        int right = list.size()-1;
        head = null;

        while(left < right){
            ListNode node1 = list.get(left);
            ListNode node2 = list.get(right);
            node1.next = node2;
            if(head == null){
                head = node1;
                curr = head;
            } else{
                curr.next = node1;
            }
            curr = node2;
            ++left;
            --right;
        }
        if(list.size() > 1 && list.size() % 2 == 1){
            curr.next = list.get(list.size() / 2);
            curr = curr.next;
        }
        curr.next = null;
    }
}