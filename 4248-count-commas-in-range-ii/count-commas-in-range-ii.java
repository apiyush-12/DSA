class Solution {
    public long countCommas(long n) {
        long commas = 0;
        long threshold = 1000;
        while(threshold <= n){
            commas += n - threshold + 1;
            threshold *= 1000;
        }
        return commas;
    }
}