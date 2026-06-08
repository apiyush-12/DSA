// class Solution {
//     public boolean isHappy(int n) {
//         Set<Integer> visited = new HashSet<>();
//         while(n!= 1 && !visited.contains(n)){
//             visited.add(n);
//             n = getHappy(n);
//         }
//         return n == 1;
//     }

//     private static int getHappy(int n){
//         int sum = 0;
//         while(n>0){
//             int digit = n%10;
//             sum  += digit * digit;
//             n /= 10;
//         }
//         return sum;
//     }
// }


class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set=new HashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            int happy=0;
            while(n>0){
                int digit=n%10;
                happy +=digit*digit;
                n/=10;
            }
            n=happy;
        }
        return n==1;
    
    }
}