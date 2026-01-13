// class Solution {
//     public int largestRectangleArea(int[] heights) {
//         int maxArea=0;
//         Stack<Integer> stack=new Stack<>();
//         int n=heights.length;
//         for(int i=0; i<=n; i++){
//             int currH=(i==n) ? 0 : heights[i];
//             while(!stack.isEmpty() && currH < heights[stack.peek()]){
//                 int height=heights[stack.pop()];
//                 int width=stack.isEmpty() ? i : i-stack.peek()-1;
//                 maxArea=Math.max(maxArea, height*width);
//             }
//             stack.push(i);
//         }
//         return maxArea;
//     }
// }

// piyush
class Solution {
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<int[]> stack = new ArrayDeque<>(); 

        for (int i = 0; i < heights.length; i++) {
            int start = i;

            
            while (!stack.isEmpty() && heights[i] < stack.peek()[0]) {
                int[] top = stack.pop();
                int height = top[0];
                int index = top[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index; 
            }

            stack.push(new int[]{heights[i], start});
        }

          while (!stack.isEmpty()) {
            int[] top = stack.pop();
            int height = top[0];
            int index = top[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }

        return maxArea;
    }
}