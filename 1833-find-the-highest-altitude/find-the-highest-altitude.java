class Solution {
    public int largestAltitude(int[] gain) {
        int curr = 0, max = 0;
        for(int g : gain){
            curr += g;
            max = Math.max(curr, max);
        }
        return max;
    }
}