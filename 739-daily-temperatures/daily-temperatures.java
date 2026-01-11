// class Solution {
//     public int[] dailyTemperatures(int[] temperatures) {
//         int n=temperatures.length;
//         int[] ans=new int[n];
//         Stack <Integer> stack=new Stack<>();
//         for(int i=0; i<n; i++){
//             while(!stack.isEmpty() && temperatures[i]>temperatures[stack.peek()]){
//                 int index=stack.pop();
//                 ans[index]=i-index;
//             }
//             stack.push(i);
//         }
//         return ans;
//     }
// }

class Solution{
    public int[] dailyTemperatures(int[] temperatures){
        int n=temperatures.length;
        int[] ans=new int[n];
        for(int i=n-2; i>=0; i--){
            int j=i+1;
            while(j<n && temperatures[j]<=temperatures[i]){
                if(ans[j]==0){
                    j=n;
                    break;
                }
                j+=ans[j];
            }
            if(j<n){
                ans[i]=j-i;
            }
        }
        return ans;
    }
}