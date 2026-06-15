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


// class Solution {
//     public int pairSum(ListNode head) {
//         ListNode slow = head;
//         ListNode fast = head;
//         while(fast.next != null &&fast.next.next != null){
//             slow = slow.next;
//             fast = fast.next.next;
//         }
//         ListNode prev = null;
//         ListNode curr = slow.next;
//         ListNode next;
//         while(curr != null){
//             next = curr.next;
//             curr.next = prev;
//             prev = curr;
//             curr = next;
//         }
//         int ans = 0;
//         while(prev != null){
//             int temp = prev.val + head.val;
//             prev = prev.next;
//             head = head.next;
//             ans = Math.max(ans, temp);
//         }
//         return ans;
//     }
// }


class Solution{
    public int pairSum(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        int ans = 0;
        while(prev != null){
            int temp = prev.val + head.val;
            prev = prev.next;
            head = head.next;
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}