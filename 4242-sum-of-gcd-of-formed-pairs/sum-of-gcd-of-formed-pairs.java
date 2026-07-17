class Solution {
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int max = 0;
        int[] prefixgcd = new int[n];
        int k=0;
        for(int num : nums){
            max = Math.max(num, max);
            prefixgcd[k] = gcd(num, max);
            k++;
        }

        Arrays.sort(prefixgcd);
        int i=0, j=n-1;
        long sum = 0;
        while(i<j){
            sum += gcd(prefixgcd[i], prefixgcd[j]);
            i++;
            j--;
        }
        return sum;
    }
    private int gcd(int a, int b){
        if(a==0) return b;
        return gcd(b%a, a);
    }
} 