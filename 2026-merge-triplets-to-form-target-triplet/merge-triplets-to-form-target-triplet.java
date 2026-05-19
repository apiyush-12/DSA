class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] maxVal = new int[3];
        for(int[] triplet : triplets){
            if(maxVal[0] == target[0] && maxVal[1] == target[1] && maxVal[2] == target[2]) return true;
            if(triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]){
                maxVal[0] = Math.max(maxVal[0], triplet[0]);
                maxVal[1] = Math.max(maxVal[1], triplet[1]);
                maxVal[2] = Math.max(maxVal[2], triplet[2]);
            }
        }
        
        return maxVal[0] == target[0] && maxVal[1] == target[1] && maxVal[2] == target[2];
    }
}