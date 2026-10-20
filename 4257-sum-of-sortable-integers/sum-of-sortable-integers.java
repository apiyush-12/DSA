// class Solution {
//     public int sortableIntegers(int[] nums) {
//         int n = nums.length;
//         int ans = 0;
//         for (int k = 1; k <= n; k++) {
//             if (n % k != 0) {
//                 continue;
//             }
//             boolean valid = true;
//             int prevMax = Integer.MIN_VALUE;
//             for (int start = 0; start < n; start += k) {
//                 int end = start + k;
//                 int min = Integer.MAX_VALUE;
//                 int max = Integer.MIN_VALUE;
//                 int descents = 0;

//                 for (int i = start; i < end; i++) {
//                     min = Math.min(min, nums[i]);
//                     max = Math.max(max, nums[i]);
//                     int next = (i + 1 == end) ? start : i + 1;
//                     if (nums[i] > nums[next]) {
//                         descents++;
//                     }
//                 }
//                 // This block must be sortable by cyclic rotation.
//                 if (descents > 1) {
//                     valid = false;
//                     break;
//                 }
//                 // Blocks must remain sorted relative to each other.
//                 if (prevMax > min) {
//                     valid = false;
//                     break;
//                 }
//                 prevMax = max;
//             }
//             if (valid) {
//                 ans += k;
//             }
//         }
//         return ans;
//     }
// }


class Solution {
    public boolean check(int[] nums, int len) {
        int n = nums.length;
        int minn = 0;
        for (int i = 0; i < n; i += len) {
            if (nums[i] < minn) return false;
            int maxx = nums[i];
            boolean point = false;
            for (int j = i + 1; j < i + len; j++) {
                if (nums[j] < minn) return false;
                if (nums[j - 1] > nums[j]) {
                    if (point) return false;
                    point = true;
                }
                maxx = Math.max(maxx, nums[j]);
            }
            if (point) {
                if (nums[i] < nums[i + len - 1]) return false;
            }
            minn = maxx;
        }
        return true;
    }
    
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;
            if (check(nums, k)) ans += k;
        } 
        return ans;
    }
}