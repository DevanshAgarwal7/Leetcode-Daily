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
    public ListNode mergeKLists(ListNode[] list) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        for(ListNode head: list){
            if(head != null){
                pq.add(head);
            }
        }
        ListNode head = null;
        ListNode curr = null;
        while(!pq.isEmpty()){
            ListNode node = pq.remove();
            if(head == null){
                head = node;
                curr = node;
            } else{
                curr.next = node;
                curr = curr.next;
            }
            if(node.next != null){
                pq.add(node.next);
            }
        }
        return head;
    }
}