// import java.util.*;

// class Solution {
//     public long countNonDecreasingSubarrays(int[] nums, int k) {
//         int n = nums.length;

//         int[] nxt = new int[n];
//         Arrays.fill(nxt, n);

//         Stack<Integer> stack = new Stack<>();

//         // Step 1: Find next greater element index
//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
//                 nxt[stack.pop()] = i;
//             }
//             stack.push(i);
//         }

//         // Step 2: Calculate chain array
//         long[] chain = new long[n + 1];

//         for (int i = n - 1; i >= 0; i--) {
//             chain[i] = (long) nums[i] * (nxt[i] - i) + chain[nxt[i]];
//         }

//         // Step 3: Sliding window using deque
//         Deque<Integer> dq = new ArrayDeque<>();

//         int left = 0;
//         long windowSum = 0;
//         long res = 0;

//         for (int right = 0; right < n; right++) {
//             windowSum += nums[right];

//             while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[right]) {
//                 dq.pollLast();
//             }

//             dq.offerLast(right);

//             // Step 4: Check window cost
//             while (true) {
//                 int c = dq.peekFirst();

//                 long cost = chain[left] - chain[c]
//                         + (long) nums[c] * (right - c + 1)
//                         - windowSum;

//                 if (cost <= k) {
//                     break;
//                 }

//                 if (dq.peekFirst() == left) {
//                     dq.pollFirst();
//                 }

//                 windowSum -= nums[left];
//                 left++;
//             }

//             res += right - left + 1;
//         }

//         return res;
//     }
// }


import java.util.*;

class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        // Each block: {value, count}; front = leftmost, values increase toward the back
        Deque<long[]> dq = new ArrayDeque<>();
        long cost = 0, ans = 0;
        int r = n - 1;

        for (int l = n - 1; l >= 0; l--) {
            long v = nums[l];
            long cnt = 1;

            // Merge front blocks that nums[l] now dominates
            while (!dq.isEmpty() && dq.peekFirst()[0] <= v) {
                long[] b = dq.pollFirst();
                cost += (v - b[0]) * b[1];
                cnt += b[1];
            }
            dq.offerFirst(new long[]{v, cnt});

            // Shrink from the right until the cost fits within k
            while (cost > k) {
                long[] last = dq.peekLast();
                cost -= last[0] - nums[r];
                r--;
                if (--last[1] == 0) dq.pollLast();
            }

            ans += r - l + 1;
        }
        return ans;
    }
}