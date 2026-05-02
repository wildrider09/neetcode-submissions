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
    public ListNode reverseList(ListNode head) {

        ListNode temp = head;
        ListNode prev = head;

        if(head==null)
            return head;

        while(head.next !=null){

            ListNode temp1 = head.next;
            head.next = prev;
            prev = head;
            head = temp1;
        }

        head.next=prev;
        temp.next = null;

        return head;
        
    }
}
