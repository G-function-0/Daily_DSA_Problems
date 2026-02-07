//LEETCODE solution'

/*
Approach : 
    simple approach same as mergeing of to sorted array easy try to think of how you can merge to sorted array 
    DIY with a small Ex
*/



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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head1 = list1;
        ListNode head2 = list2;
        ListNode head = null;
        ListNode temp = null;

        while(head1 != null && head2 != null){
            ListNode n1 = new ListNode(head1.val);
            ListNode n2 = new ListNode(head2.val);
            if(n1.val < n2.val){
                if(head == null){
                    head = n1;
                    temp = head;
                }
                else{
                    temp.next = n1;
                    temp = temp.next;
                }
                head1 = head1.next;
            }
            else{
                if(head == null){
                    head = n2;
                    temp = n2;
                }
                else{
                    temp.next = n2;
                    temp = temp.next;
                }
                head2 = head2.next;
            }
        }

        while(head1 != null){
            ListNode n = new ListNode(head1.val);
            if(head == null){
                head = n;
                temp = n;
                head1 = head1.next;
                continue;
            }
            temp.next = n;
            temp = temp.next;
            head1 = head1.next;
        }
        while(head2 != null){
            ListNode n = new ListNode(head2.val);
            if(head == null){
                head = n;
                temp = n;
                head2 = head2.next;
                continue;
            }
            temp.next = n;
            temp = temp.next;
            head2 = head2.next;
        }

        return head;
    }
}