// class KthLargest {
//     PriorityQueue<Integer> minHeap;
//     int k;
//     public KthLargest(int k, int[] nums) {
//         this.k=k;
//         this.minHeap=new PriorityQueue<>(k);
//         for(int num : nums){
//             add(num);
//         }
//     }
    
//     public int add(int val) {
//         if(minHeap.size()<k){
//             minHeap.add(val);
//         }else if(val>minHeap.peek()){
//             minHeap.poll();
//             minHeap.offer(val);
//         }
//         return minHeap.peek();
//     }
// }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */


// piyush
 class KthLargest{
    PriorityQueue<Integer> pq;
    int k;
    public KthLargest(int k, int[] nums){
        this.k=k;
        this.pq=new PriorityQueue<>();
        for(int num : nums){
            add(num);
        }
    }
    public int add(int val){
        pq.add(val);
        if(pq.size()>k){
            pq.poll();
        }
        return pq.peek();
    }
 }