// class Solution {
    // public String reverseWords(String s) {
    //     String [] arr=s.split("\\s+");   //split on the basis of spaces
    //     StringBuilder sb=new StringBuilder("");
    //     for(int i=arr.length-1; i>=0; i--){
    //         sb.append(arr[i]+" ");
    //     }
    //     String ans=sb.toString();
    //     ans=ans.trim();
    //     return ans;
    // }

    // piyush //
    // public String reverseWords(String s){
    //     String [] arr=s.split("\\s+");
    //     StringBuilder sb=new StringBuilder("");
    //     for(int i=arr.length-1; i>=0; i--){
    //         sb.append(arr[i]+" ");
    //     }
    //     String ans=sb.toString();
    //     ans=ans.trim();
    //     return ans;
    // }

//     public String reverseWords(String s){
//         String[] arr=s.split("\\s+");
//         StringBuilder sb=new StringBuilder("");
//         for(int i=arr.length-1; i>=0; i--){
//             sb.append(arr[i]+" ");
//         }
//         String ans=sb.toString();
//         ans=ans.trim();
//         return ans;
//     }
// }

class Solution{
    public String reverseWords(String s){
        if(s==null) return null;
        char[] arr=s.toCharArray();
        int n=arr.length;
        reverse(arr, 0, n-1);
        reverseWord(arr,n);
        return cleanSpaces(arr, n);
    }
    private void reverse(char[] a, int i, int j){
        while(i<j){
            char t=a[i];
            a[i]=a[j];
            a[j]=t;
            i++;
            j--;
        }
    }
    public void reverseWord(char[] a, int n){
        int i=0, j=0;
        while(i<n){
            while(i<j || i<n && a[i]==' '){
                i++;
            }
            while(j<i || j<n && a[j]!=' '){
                j++;
            }
            reverse(a, i, j-1);
        }
    }
    String cleanSpaces(char[] a, int n){
        int i=0, j=0;
        while(j<n){
            while(j<n && a[j]==' '){
                j++;
            }
            while(j<n && a[j]!=' '){
                a[i]=a[j];
                i++;
                j++;
            }
            while(j<n && a[j]==' '){
               j++;
            }
            if(j<n){
                a[i]=' ';
                i++;
            }
        }
        return new String(a).substring(0, i);
    }
}