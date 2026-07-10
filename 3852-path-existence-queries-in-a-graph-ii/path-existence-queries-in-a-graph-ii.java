// class Solution {
//     public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
//         int sorted[][] = new int[n][2];
//         for(int i=0; i<n; i++){
//             sorted[i][0] = nums[i];
//             sorted[i][1] = i;
//         }
//         Arrays.sort(sorted, (a, b)->Integer.compare(a[0], b[0]));
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i=0; i<n; i++) map.put(sorted[i][1], i);

//         int LOG = 1;
//         while((1<<LOG) < n) LOG++;
//         int[][] up = new int[n][LOG];
//         int r=0;
//         for(int l=0; l<n; l++){
//             if(r<l) r=l;
//             while(r+1 < n && sorted[r+1][0]-sorted[l][0] <= maxDiff) r++;
//             up[l][0] = r;
//         }
//         for(int j=1; j<LOG; j++){
//             for(int ind=0; ind<n; ind++){
//                 up[ind][j] = up[up[ind][j-1]][j-1];
//             }
//         }
//         int[] ans = new int[queries.length];
//         for(int i=0; i<queries.length; i++){
//             int src = map.get(queries[i][0]);
//             int dest = map.get(queries[i][1]);

//             if(src > dest){
//                 int temp = src;
//                 src = dest;
//                 dest = temp;
//             }
//             if(src==dest){
//                 ans[i]=0;
//                 continue;
//             }
//             int curr = src;
//             int hops = 0;
//             for(int j=LOG-1; j>=0; j--){
//                 if(up[curr][j] < dest){
//                     curr = up[curr][j];
//                     hops += (1<<j);
//                 }
//             }
//             if(up[curr][0] >= dest){
//                 ans[i] = hops + 1;
//             }else{
//                 ans[i] = -1;
//             }
//         }
//         return ans;
//     }
// }


class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length, l = 1;
        int[] ans = new int[m];
        long[] sorted = new long[n];
        for(int i = 0; i < n; i++) sorted[i] = (long)nums[i] << 32 | i;
        Arrays.sort(sorted);

        for(int i = 1; i < n; i <<= 1) l++;
        int[][] jumps = new int[l][n];

        int[] rank = new int[n];
        int right = 0;
        for(int i = 0; i < n; i++) {
            rank[(int)sorted[i]] = i;
            while(right < n && (sorted[right] >>> 32) <= (sorted[i] >>> 32) + maxDiff) right++;
            jumps[0][i] = right - 1;
        }
        for(int i = 1; i < l; i++) {
            for(int j = 0; j < n; j++) jumps[i][j] = jumps[i - 1][jumps[i - 1][j]];
        }
        for(int i = 0; i < m; i++) {
            int a = rank[queries[i][0]], b = rank[queries[i][1]];
            if(a > b) {
                int temp = a;
                a = b;
                b = temp;
            }
            ans[i] = jumps[l - 1][a] < b ? -1 : calcJumps(jumps, a, b, l);
        }
        return ans;
    }
    private int calcJumps(int[][] jumps, int a, int b, int right) {
        if(a == b) return 0;
        if(jumps[0][a] >= b) return 1;
        int left = 0;
        while(left < right) {
            int mid = left + right + 1 >>> 1;
            if(jumps[mid][a] < b) left = mid;
            else right = mid - 1;
        }
        return (1 << left) + calcJumps(jumps, jumps[left][a], b, left);
    }
}