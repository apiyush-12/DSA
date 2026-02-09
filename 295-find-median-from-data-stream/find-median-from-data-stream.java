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

// piyush
class MedianFinder {
    private PriorityQueue<Integer> maxH; 
    private PriorityQueue<Integer> minH; 
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
        if (maxH.size() > minH.size() + 1) {    //check balance
            minH.offer(maxH.poll());
        } 
        else if (minH.size() > maxH.size()) {
            maxH.offer(minH.poll());
        }
    }
    public double findMedian() {
        // return maxH.size() > minH.size() ? maxH.peek() : (maxH.peek() + minH.peek()) / 2.0;
        if (maxH.size() > minH.size()) {
            return maxH.peek();
        }

        return (maxH.peek() + minH.peek()) / 2.0;
    }
}

