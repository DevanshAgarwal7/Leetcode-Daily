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
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode listHead = null;
        ListNode listCurr = null;
        ListNode curr = head;
        Set<Integer> set = new HashSet<>();
        for(int element: nums){
            set.add(element);
        }
        while(curr != null){
            if(!set.contains(curr.val)){
                if(listHead == null){
                    listHead = curr;
                    listCurr = curr;
                } else{
                    listCurr.next = curr;
                    listCurr = listCurr.next;
                }
            }
            curr = curr.next;
        }
        if(listCurr != null){
            listCurr.next = null;
        }
        return listHead;
    }
}