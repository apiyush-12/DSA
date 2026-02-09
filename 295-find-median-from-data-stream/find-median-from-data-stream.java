// class MedianFinder {
//     private PriorityQueue<Integer> maxH=new PriorityQueue<>((a, b) -> b-a); 
//     private PriorityQueue<Integer> minH=new PriorityQueue<>();

//     public MedianFinder() {
//     }
    
//     public void addNum(int num) {
//         maxH.offer(num);
//         minH.offer(maxH.poll());
//         if(maxH.size()<minH.size()){
//             maxH.offer(minH.poll());
//         }   
//     }
    
//     public double findMedian() {
//         return maxH.size() > minH.size() ? maxH.peek() : (maxH.peek() + minH.peek())/2.0;
//     }
// }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */


 class MedianFinder {

    private PriorityQueue<Integer> maxH; // smaller half (max heap)
    private PriorityQueue<Integer> minH; // larger half (min heap)

    public MedianFinder() {
        maxH = new PriorityQueue<>((a, b) -> b - a);
        minH = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (maxH.isEmpty() || num <= maxH.peek()) {
            maxH.offer(num);
        } else {
            minH.offer(num);
        }
        if (maxH.size() > minH.size() + 1) {
            minH.offer(maxH.poll());
        } 
        else if (minH.size() > maxH.size()) {
            maxH.offer(minH.poll());
        }
    }

    public double findMedian() {

        if (maxH.size() > minH.size()) {
            return maxH.peek();
        }

        return (maxH.peek() + minH.peek()) / 2.0;
    }
}
