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
//     public ListNode mergeKLists(ListNode[] lists) {
//         PriorityQueue<Integer> minHeap=new PriorityQueue<>();
//         for(ListNode list : lists){
//             while(list!=null){
//                 minHeap.add(list.val);
//                 list=list.next;
//             }
//         }
//         ListNode dummy=new ListNode(1);
//         ListNode merge=dummy;
//         while(!minHeap.isEmpty()){
//             merge.next=new ListNode(minHeap.remove());
//             merge=merge.next;
//         }
//         return dummy.next;
//     }
// }

class Solution{
    public ListNode mergeKLists(ListNode[] lists){
        if(lists.length==0){
            return null;
        }else if(lists.length==1){
            return lists[0];
        }
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->a.val-b.val);
        for(int i=0; i<lists.length; i++){
            ListNode tempH=lists[i];
            while(tempH!=null){
                pq.add(tempH);
                tempH=tempH.next;
            }
        }
        ListNode dummy=new ListNode(-1);
        ListNode ans=dummy;
        while(pq.size()>0){
            dummy.next=pq.remove();
            dummy=dummy.next;
        }
        dummy.next=null;
        return ans.next;
    }
}