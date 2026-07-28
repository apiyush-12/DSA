// class Solution {
//     public int maxProduct(int[] nums) {
//         int first = 0, second = 0;
//         for (int num : nums) {
//             if (num > first) {
//                 second = first;
//                 first = num;
//             } else if (num > second)
//                 second = num;
//         }
//         return (first - 1) * (second - 1);
//     }
// }

// piyush
class Solution {
    public int maxProduct(int[] nums) {
        int first = 0, second = 0;
        for (int num : nums) {
            if (num > first) {
                second = first;
                first = num;
            } else if (second < num) {
                second = num;
            }
        }
        return (first - 1) * (second - 1);
    }
}