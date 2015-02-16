/*
** @author Suman Shakya
** 02-15-2015

** Given a singly linked list L: L0→L1→…→Ln-1→Ln, reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
** You must do this in-place without altering the nodes' values.
** For example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
** LeetCode OJ - https://oj.leetcode.com/problems/reorder-list/
*/

public class Solution{
    public static void main(String[] args){
        new Solution().test();
    }
    
    public void test(){
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;
        n8.next = null;
        reorderList(n1);
        print(n1);
    }
    
    public void print(ListNode head){
        while(head.next != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println(head.val);
    }
    
    public void reorderList(ListNode head){
        if(head == null || head.next == null)
            return;
            
        ListNode p1 = head;
        ListNode p2 = head;
        
        //Find the middle pointer
        while(p2.next != null && p2.next.next != null){
            p1 = p1.next;
            p2 = p2.next.next;
        }
        //p1 is now the middle pointer
        
        //Reverse nodes after p1
        p2 = p1.next;
        while(p2.next != null){
            ListNode p3 = p1.next;
            p1.next = p2.next;
            p2.next = p2.next.next;
            p1.next.next = p3;
        }
        
        //Reorder the list
        p2 = p1.next;
        p1.next = null;
        p1 = head;
        while(p1 != null && p2 != null){
            ListNode p3 = p1.next;
            p1.next = p2;
            p2 = p2.next;
            p1.next.next = p3;
            p1 = p3;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}