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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;

        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }

        if(size == 1){
            head = null;
            return head;
        }
        
        int i = 0;
        ListNode t = head;
        while(i < size-n-1 && t.next != null){
            t = t.next;
            i++;
        }
        t.next = t.next.next;
        return head;
    }
}