// class Solution {
//     int MOD = 1000000007;
//     public int zigZagArrays(int n, int l, int r) {
//         int k = r-l+1;
//         int size = 2 * k;
//         long[][] initial = new long[size][1];
//         for(int v=1; v<= k; v++){
//             initial[v-1][0] = k-v;
//             initial[k+v-1][0] = v-1;
//         }
//         long[][] T = new long[size][size];
//         for(int v=1; v<=k; v++){
//             for(int u=1; u<v; u++){
//                 T[k+v-1][u-1] = 1;
//             }
//             for(int u=v+1; u<=k; u++){
//                 T[v-1][k+u-1]=1;
//             }
//         }
//         long[][] Tn = power(T, n-2);
//         long[][] ans = multiply(Tn, initial);

//         long total = 0;
//         for(int i=0; i<size; i++){
//             total = (total + ans[i][0]) % MOD;
//         }
//         return (int) total;
//     }
//     private long[][] multiply(long[][] A, long[][] B){
//         int rA = A.length;
//         int cA = A[0].length;
//         int cB = B[0].length;
//         long[][] C = new long[rA][cB];
//         for(int i=0; i<rA; i++){
//             for(int j=0; j<cB; j++){
//                 long sum = 0;
//                 for(int k=0; k<cA; k++){
//                     sum = (sum + A[i][k]*B[k][j]) % MOD;
//                 }
//                 C[i][j] = sum;
//             }
//         }
//         return C;
//     }
//     private long[][] power(long[][] base, long exp){
//         int n = base.length;
//         long[][] res = new long[n][n];
//         for(int i=0; i<n; i++) res[i][i] = 1;
//         long[][] b = base;
//         while(exp > 0){
//             if(exp % 2 == 1) res =multiply(res, b);
//             b = multiply(b, b);
//             exp /= 2; 
//         }
//         return res;
//     }
// }


// class Solution {
//     public int zigZagArrays(int n, int l, int r) {
//         int len = r - l + 1;
//         long[][] m1 = new long[len][len];
//         long[][] m2 = new long[len][len];
//         for (int i = 0; i < len; i++) {
//             for (int j = i + 1; j < len; j++) {
//                 m1[i][j] = 1;
//             }
//             for (int j = 0; j < i; j++) {
//                 m2[i][j] = 1;
//             }
//         }
//         long[][] m = pro(m1, m2);
//         long[] arr = new long[len];
//         Arrays.fill(arr, 1);
//         n--;
//         int count = n / 2;
//         while (count > 0) {
//             if (count % 2 == 1)
//                 arr = pro(arr, m);
//             m = pro(m);
//             count /= 2;
//         }
//         if (n % 2 == 1)
//             arr = pro(arr, m1);
//         long res = 0;
//         for (long num : arr) {
//             res += num;
//         }
//         return (int) (res * 2 % mod);
//     }

//     int mod = 1_000_000_007;

//     public long[][] pro(long[][] a) {
//         long[][] res = new long[a.length][a[0].length];
//         for (int i = 0; i < res.length; i++) {
//             for (int k = 0; k < res.length; k++) {
//                 if (a[i][k] == 0)
//                     continue;
//                 for (int j = 0; j < res.length; j++) {
//                     res[i][j] = (res[i][j] + a[i][k] * a[k][j]) % mod;
//                 }
//             }
//         }
//         return res;
//     }

//     public long[][] pro(long[][] a, long[][] b) {
//         long[][] res = new long[a.length][a[0].length];
//         for (int i = 0; i < res.length; i++) {
//             for (int k = 0; k < res.length; k++) {
//                 if (a[i][k] == 0)
//                     continue;
//                 for (int j = 0; j < res.length; j++) {
//                     res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % mod;
//                 }
//             }
//         }
//         return res;
//     }

//     public long[] pro(long[] a, long[][] b) {
//         long[] res = new long[a.length];
//         for (int j = 0; j < res.length; j++) {
//             if (a[j] == 0)
//                 continue;
//             for (int i = 0; i < res.length; i++) {
//                 res[i] = (res[i] + a[j] * b[j][i]) % mod;
//             }
//         }
//         return res;
//     }
// }


// piyush
class Solution{
    public int zigZagArrays(int n, int l, int r){
        int len = r-l+1;
        long[][] m1 = new long[len][len];
        long[][] m2 = new long[len][len];
        for(int i=0; i<len; i++){
            for(int j=i+1; j<len; j++) m1[i][j]=1;
            for(int j=0; j<i; j++) m2[i][j]=1;
        }
        long[][] m = pro(m1, m2);
        long[] arr = new long[len];
        Arrays.fill(arr, 1);
        n--;
        int count=n/2;
        while(count > 0){
            if(count % 2 == 1) arr = pro(arr, m);
            m = pro(m);
            count /=2;
        }
        if(n%2==1) arr = pro(arr, m1);
        long res = 0;
        for(long num : arr) res += num;
        return (int) (res * 2 % mod);
    } 
    
    int mod = 1000000007;
    public long[][] pro(long[][] a){
        long[][] res = new long[a.length][a[0].length];
        for(int i=0; i<res.length; i++){
            for(int k=0; k<res.length; k++){
                if(a[i][k]==0) continue;
                for(int j=0; j<res.length; j++){
                    res[i][j] = (res[i][j] + a[i][k] * a[k][j]) % mod;
                }
            }
        }
        return res;
    }

    public long[][] pro(long[][] a, long[][] b){
        long[][] res = new long[a.length][a[0].length];
        for(int i=0; i<res.length; i++){
            for(int k=0; k<res.length; k++){
                if(a[i][k] == 0) continue;
                for(int j=0; j<res.length; j++){
                    res[i][j] = (res[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return res;
    }

    public long[] pro(long[] a, long[][] b){
        long[] res = new long[a.length];
        for(int i=0; i<res.length; i++){
            if(a[i] == 0) continue;
            for(int j=0; j<res.length; j++){
                res[j] = (res[j] + a[i] * b[i][j]) % mod;
            }
        }
        return res;
    }
}