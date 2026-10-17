// import java.util.*;

// class Solution {
//     public int minSwaps(int[] nums) {
//         int n = nums.length;
//         int[][] arr = new int[n][2];
//         for (int i = 0; i < n; i++) {
//             int num = nums[i];
//             int sum = 0;
//             while (num > 0) {
//                 sum += num % 10;
//                 num /= 10;
//             }
//             arr[i][0] = nums[i];
//             arr[i][1] = sum;
//         }
//         Arrays.sort(arr, (a, b) -> {
//             if (a[1] != b[1]) {
//                 return a[1] - b[1];
//             }
//             return a[0] - b[0];
//         });

//         Map<Integer, Integer> index = new HashMap<>();
//         for (int i = 0; i < n; i++) {
//             index.put(nums[i], i);
//         }
//         int swaps = 0;
//         for (int i = 0; i < n; i++) {
//             int correctIndex = index.get(arr[i][0]);
//             if (correctIndex != i) {
//                 int temp = nums[i];
//                 nums[i] = nums[correctIndex];
//                 nums[correctIndex] = temp;
//                 index.put(nums[correctIndex], correctIndex);
//                 index.put(nums[i], i);
//                 swaps++;
//             }
//         }
//         return swaps;
//     }
// }


class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int[] digitSum = new int[n];
        for (int i = 0; i < n; i++) {
            int x = nums[i],
                sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            digitSum[i] = sum;
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (a, b) -> {
            if (digitSum[a] != digitSum[b]) {
                return Integer.compare(digitSum[a], digitSum[b]);
            }
            return Integer.compare(nums[a], nums[b]);
        });

        int[] targetPos = new int[n];
        for (int pos = 0; pos < n; pos++) {
            targetPos[indices[pos]] = pos;
        }
        boolean[] visited = new boolean[n];
        int cycles = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                cycles++;
                int j = i;
                while (!visited[j]) {
                    visited[j] = true;
                    j = targetPos[j];
                }
            }
        }
        return n - cycles;
    }
}