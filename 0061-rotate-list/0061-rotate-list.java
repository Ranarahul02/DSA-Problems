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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k==0) return head;

        ListNode temp = head;
        int size = 1;
        while(temp.next != null){
            size++;
            temp = temp.next;
        }

        k = k%size;
        if(k==0) return head;
        
        temp.next = head;

        int step = size-k;
        for(int i=1;i<step;i++){
            head = head.next;
        }
        ListNode newHead = head.next;
        head.next = null;

        return newHead;
    }
}