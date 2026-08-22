class Solution {
    public boolean checkDivisibility(int n) {
        int original = n;
        int sum = 0;
        int product = 1;
        while(n != 0){
            int lastD = n % 10;
            sum += lastD;
            product *= lastD;
            n = n / 10;
        }
        int c = sum + product;
        return (original % c) == 0;
    }
}