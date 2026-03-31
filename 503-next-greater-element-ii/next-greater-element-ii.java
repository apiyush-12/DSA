// class Solution {
//     public int[] nextGreaterElements(int[] nums) {
//         int n=nums.length;
//         int[] res = new int[n];
//         Arrays.fill(res, -1);
//         Stack<Integer> st = new Stack<>();
//         for(int i=n*2-1; i>=0; i--){
//             int index=i%n;
//             while(!st.isEmpty() && nums[st.peek()]<=nums[index]) st.pop();
//             if(!st.isEmpty() && i<n) res[index]=nums[st.peek()];
//             st.push(index);
//         }
//         return res;
//     }
// }

class Solution{
    public int[] nextGreaterElements(int[] nums){
        int n=nums.length;
        Deque<Integer> st = new ArrayDeque<>();
        int[] result=new int[n];
        Arrays.fill(result, -1);
        for(int i=0; i<2*n; i++){
            int num=nums[i%n];
            while(!st.isEmpty() && nums[st.peek()] < num) result[st.pop()]=num;
            if(i<n) st.push(i);
        }
        return result;
    }
}