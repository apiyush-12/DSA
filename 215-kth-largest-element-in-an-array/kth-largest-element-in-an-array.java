class Solution {
    // public int findKthLargest(int[] nums, int k) {
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     for(int i=0; i<nums.length; i++){
    //         if(pq.size()<k){
    //             pq.add(nums[i]);
    //         }else if(pq.peek()<nums[i]){
    //             pq.remove();
    //             pq.add(nums[i]);
    //         }
    //     }
    //     return pq.peek();
    // }

    // piyush //
    // public int findKthLargest(int[] nums, int k){
    //     PriorityQueue<Integer> pq=new PriorityQueue<>();
    //     for(int i=0; i<nums.length; i++){
    //         if(pq.size()<k){
    //             pq.add(nums[i]);
    //         }else if(pq.peek()<nums[i]){
    //             pq.remove();
    //             pq.add(nums[i]);
    //         }
    //     }
    //     return pq.peek();
    // }
    
    public int findKthLargest(int[] nums, int k) {
        int[] count = new int[20001];

        for (int num : nums) 
            count[num + 10000]++;

        for (int i = count.length - 1; i >= 0; i--) 
            if (count[i] > 0) {
                k -= count[i];
                if (k <= 0) return i - 10000;
            }
        
        return -1;
    }
}