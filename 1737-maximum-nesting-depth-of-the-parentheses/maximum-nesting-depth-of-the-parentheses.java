class Solution {
    public int maxDepth(String s) {
        int n = s.length();
        int count = 0;
        int maxDepth = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxDepth = Math.max(maxDepth, count);
            if(s.charAt(i) == '(') count++;
            else if(s.charAt(i) == ')') count--;
            else continue;
        }
        return maxDepth;
    }
}