// class Solution {
//     public int[] minInterval(int[][] intervals, int[] queries) {
//         int n = queries.length;
//         int[] result = new int[n];

//         Integer[] queryIndices = new Integer[n];
//         for(int i = 0; i<n; i++){
//             queryIndices[i] = i;
//         }
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         Arrays.sort(queryIndices, (a,b) -> Integer.compare(queries[a], queries[b]));
//         PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1]-a[0], b[1]-b[0]));
//         int intervalIndex = 0;
//         for(int i = 0; i<n; i++){
//             int query = queries[queryIndices[i]];

//             while(intervalIndex < intervals.length && intervals[intervalIndex][0] <= query){
//                 int left = intervals[intervalIndex][0];
//                 int right = intervals[intervalIndex][1];
//                 if(right >= query) minHeap.offer(new int[]{left, right});
//                 intervalIndex++;
//             }

//             while(!minHeap.isEmpty() && minHeap.peek()[1] < query) minHeap.poll();
//             if(minHeap.isEmpty()) result[queryIndices[i]] = -1;
//             else{
//                 int[] smallInterval = minHeap.peek();
//                 result[queryIndices[i]] = smallInterval[1]-smallInterval[0]+1;
//             }
//         }
//         return result;
//     }
// }


// piyush
// class Solution {
//     public int[] minInterval(int[][] intervals, int[] queries) {
//         Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
//         int n = queries.length;
//         int[][] queriesIndex = new int[n][2];
//         for (int i=0; i<n; i++) {
//             queriesIndex[i][0] = queries[i];
//             queriesIndex[i][1] = i;
//         }
//         Arrays.sort(queriesIndex, (a,b) -> a[0]-b[0]);
//         PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> (a[1]-a[0]) - (b[1]-b[0]));
//         int j=0, len = intervals.length;
//         int[] result = new int[n];
//         for (int i=0; i<n; i++) {
//             int queryVal = queriesIndex[i][0];
//             int queryInd = queriesIndex[i][1];
//             while (j<len && intervals[j][0] <= queryVal) {
//                 queue.offer(intervals[j]);
//                 j++;
//             }
//             while (!queue.isEmpty() && queue.peek()[1] < queryVal) {
//                 queue.remove();
//             }
//             int minInterval = queue.isEmpty() ? -1 : queue.peek()[1] - queue.peek()[0] + 1;
//             result[queryInd] = minInterval;
//         }
//         return result;
//     }
// }

class Solution{
    public int[] minInterval(int[][] intervals, int[] queries){
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int n = queries.length;
        int[][] queriesIndex = new int[n][2];
        for(int i=0; i< n; i++){
            queriesIndex[i][0] = queries[i];
            queriesIndex[i][1] = i;
        }

        Arrays.sort(queriesIndex, (a, b) -> a[0]-b[0]);
        PriorityQueue <int[]> pq = new PriorityQueue<>((a, b)-> (a[1]-a[0])-(b[1]-b[0]));
        int j = 0, len = intervals.length;
        int[] result = new int[n];
        for(int i=0; i<n; i++){
            int queryVal = queriesIndex[i][0];
            int queryIdx = queriesIndex[i][1];
            while(j < len && intervals[j][0] <=queryVal){
                pq.offer(intervals[j]);
                j++;
            }
            while(!pq.isEmpty() && pq.peek()[1] < queryVal){
                pq.remove();
            }
            int minInterval = pq.isEmpty() ? -1 : pq.peek()[1]-pq.peek()[0] + 1;
            result[queryIdx] = minInterval;
        }
        return result;
    }
}