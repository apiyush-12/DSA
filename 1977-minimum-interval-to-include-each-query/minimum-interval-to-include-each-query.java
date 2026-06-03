class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = queries.length;
        int[] result = new int[n];

        Integer[] queryIndices = new Integer[n];
        for(int i = 0; i<n; i++){
            queryIndices[i] = i;
        }
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(queryIndices, (a,b) -> Integer.compare(queries[a], queries[b]));
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[1]-a[0], b[1]-b[0]));
        int intervalIndex = 0;
        for(int i = 0; i<n; i++){
            int query = queries[queryIndices[i]];

            while(intervalIndex < intervals.length && intervals[intervalIndex][0] <= query){
                int left = intervals[intervalIndex][0];
                int right = intervals[intervalIndex][1];
                if(right >= query) minHeap.offer(new int[]{left, right});
                intervalIndex++;
            }

            while(!minHeap.isEmpty() && minHeap.peek()[1] < query) minHeap.poll();
            if(minHeap.isEmpty()) result[queryIndices[i]] = -1;
            else{
                int[] smallInterval = minHeap.peek();
                result[queryIndices[i]] = smallInterval[1]-smallInterval[0]+1;
            }
        }
        return result;
    }
}