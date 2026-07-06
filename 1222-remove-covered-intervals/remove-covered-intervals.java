// class Solution {
//     public int removeCoveredIntervals(int[][] intervals) {
//         int n = intervals.length;
//         Arrays.sort(intervals, (a, b) -> {
//             if (a[0] == b[0])
//                 return b[1] - a[1];
//             return a[0] - b[0];
//         });

//         int remove = 0;
//         int prev = 0;
//         for (int i = 1; i < n; i++) {
//             int start = intervals[i][0], end = intervals[i][1];
//             int pStart = intervals[prev][0], pEnd = intervals[prev][1];
//             if (start >= pStart && end <= pEnd)
//                 remove++;
//             else
//                 prev = i;
//         }
//         return n - remove;
//     }
// }


// piyush
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int count = 0, maxEnd = 0;
        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                count++;
                maxEnd = interval[1];
            }
        }
        return count;
    }
}