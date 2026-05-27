// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
//         LinkedList<int[]> res = new LinkedList<>();   
//         for(int[] interval : intervals){
//             if(res.isEmpty() || res.getLast()[1] < interval[0]) res.add(interval);
//             else res.getLast()[1] = Math.max(res.getLast()[1], interval[1]);
//         }
//         return res.toArray(new int[res.size()][]);
//     }
// }

// class Solution {
//     public int[][] merge(int[][] intervals) {
//         Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
//         List<int[]> ans = new ArrayList<>();
//         int[] prev = intervals[0];
//         for(int i=1;i<intervals.length;i++){
//             if(intervals[i][0]<=prev[1]) prev[1]=Math.max(prev[1],intervals[i][1]);
//             else{
//                 ans.add(prev);
//                 prev=intervals[i];
//             }
//         }
//         ans.add(prev);
//         return ans.toArray(new int[ans.size()][]);
//     }
// }


// class Solution {
//     public int[][] merge(int[][] intervals) {
//         List<int[]> res = new ArrayList<>();
//         int rows = intervals.length;
//         if (rows == 0) {
//             return res.toArray(new int[res.size()][]);
//         }
//         Arrays.sort(intervals, (a,b)->a[0]-b[0]);
//         int start = intervals[0][0];
//         int end = intervals[0][1];
//         for (int i = 1; i < rows; i++) {
//             if (intervals[i][0] <= end) {
//                 end = Math.max(end, intervals[i][1]);
//             } else {
//                 res.add(new int[] {start, end});
//                 start = intervals[i][0];
//                 end = intervals[i][1];
//             }
//         }
//         res.add(new int[] {start, end});
//         return res.toArray(new int[res.size()][]);
//     }
// }

// piyush
class Solution{
    public int[][] merge(int[][] intervals){
        List<int[]> res = new ArrayList<>();
        int rows = intervals.length;
        if(rows == 0) return res.toArray(new int[res.size()][]);
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i< rows; i++){
            if(intervals[i][0] <=end){
                end = Math.max(end, intervals[i][1]);
            }else{
                res.add(new int[] {start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[] {start, end});
        return res.toArray(new int[res.size()][]);
    }
}