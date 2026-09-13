// class Solution {
//     public int largestOverlap(int[][] img1, int[][] img2) {
//         Map<String, Integer> map = new HashMap<>();
//         int n = img1.length;
//         int maxOverlap = 0;
//         for(int r1=0; r1<n; r1++){
//             for(int c1 = 0; c1<n; c1++){
//                 if(img1[r1][c1] == 1){
//                     for(int r2=0; r2<n; r2++){
//                         for(int c2=0; c2<n; c2++){
//                             if(img2[r2][c2] == 1){
//                                 int rowShift = r2 - r1;
//                                 int colShift = c2 - c1;
//                                 String shift = rowShift + "," + colShift;
//                                 int count = map.getOrDefault(shift, 0) + 1;
//                                 map.put(shift, count);
//                                 maxOverlap = Math.max(maxOverlap, count);
//                             }
//                         }
//                     }
//                 }
//             }
//         }
//         return maxOverlap;
//     }
// }

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        final int MAGIC = 100;
        final int n = img1.length;
        int ans = 0;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        Map<Integer, Integer> offsetCount = new HashMap<>();

        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j) {
                if (img1[i][j] == 1)
                    ones1.add(new int[] { i, j });
                if (img2[i][j] == 1)
                    ones2.add(new int[] { i, j });
            }

        for (int[] a : ones1)
            for (int[] b : ones2) {
                final int key = (a[0] - b[0]) * MAGIC + a[1] - b[1];
                offsetCount.merge(key, 1, Integer::sum);
            }

        for (final int count : offsetCount.values())
            ans = Math.max(ans, count);

        return ans;
    }
}