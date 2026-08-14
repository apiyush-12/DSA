// class Solution {
//     private static class Node{
//         char leftChar, rightChar;
//         int prefix, suffix, max, len;
//         Node(char leftChar, char rightChar, int prefix, int suffix, int max, int len){
//             this.leftChar = leftChar;
//             this.rightChar = rightChar;
//             this.prefix = prefix;
//             this.suffix = suffix;
//             this.max = max;
//             this.len = len;
//         }
//     }

//     private char[] arr;
//     private Node[] tree;
//     public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//         int n = s.length();
//         arr = s.toCharArray();
//         tree = new Node[4*n];
//         build(1, 0, n-1);
//         int k = queryCharacters.length();
//         int[] ans = new int[k];
//         for(int i=0; i<k; i++){
//             update(1, 0, n-1, queryIndices[i], queryCharacters.charAt(i));
//             ans[i] = tree[1].max;
//         }
//         return ans;
//     }

//     private void build(int node, int left, int right){
//         if(left == right){
//             tree[node] = new Node(arr[left], arr[left], 1,1,1,1);
//             return;
//         }
//         int mid = left + (right-left) / 2;
//         build(node*2, left, mid);
//         build(node*2+1, mid+1, right);
//         tree[node] = merge(tree[node*2], tree[node*2+1]);
//     }

//     private void update(int node, int left, int right, int index, char ch){
//         if(left == right){
//             arr[index] = ch;
//             tree[node] = new Node(ch, ch, 1,1,1,1);
//             return;
//         }
//         int mid = left + (right-left)/2;
//         if(index <= mid){
//             update(node*2, left, mid, index, ch);
//         }else{
//             update(node*2+1, mid+1, right, index, ch);
//         }
//         tree[node] = merge(tree[node*2], tree[node*2+1]);
//     }

//     private Node merge(Node a, Node b){
//         int len = a.len + b.len;
//         char leftChar = a.leftChar;
//         char rightChar = b.rightChar;
//         int prefix = a.prefix;
//         if(a.prefix == a.len && a.rightChar == b.leftChar) prefix = a.len + b.prefix;
//         int suffix = b.suffix;
//         if(b.suffix == b.len && a.rightChar == b.leftChar) suffix = b.len + a.suffix;
//         int max = Math.max(a.max, b.max);
//         if(a.rightChar == b.leftChar){
//             max = Math.max(max, a.suffix + b.prefix);
//         }
//         return new Node(leftChar, rightChar, prefix, suffix, max, len);
//     }
// }




// class Solution {
//     class Node {
//         char leftChar, rightChar; 
//         int leftCount, rightCount, max, length; 
//         Node() {} 
//         Node(char c) { 
//             leftChar = c; rightChar = c; 
//             leftCount = 1; rightCount = 1; 
//             max = 1;        
//             length = 1;
//         }
//     }
//     Node[] tree; int size; 

//     public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
//         int n = s.length(), q = queryIndices.length; 
//         size = 1; while(size < n) size *= 2; 
//         tree = new Node[2 * size]; 
//         for(int i = 0; i < size; i++) 
//             tree[size + i] = (i < n) ? new Node(s.charAt(i)) : new Node(); 
//         for(int i = size - 1; i >= 1; i--) 
//             tree[i] = merge(tree[2 * i], tree[2 * i + 1]); 

//         int[] ans = new int[q]; 
//         for(int i = 0; i < q; i++) { 
//             update(queryIndices[i], queryCharacters.charAt(i)); 
//             ans[i] = tree[1].max; 
//         }
//         return ans; 
//     }

//     private void update(int pos, char c) {
//         int idx = pos + size; 
//         tree[idx] = new Node(c); 
//         for(idx /= 2; idx >= 1; idx /= 2) tree[idx] = merge(tree[2 * idx], tree[2 * idx + 1]); 
//     }

//     private Node merge(Node left, Node right) {
//         if(left.length == 0) return right; 
//         if(right.length == 0) return left; 
//         Node res = new Node(); 
//         res.length = left.length + right.length; 
//         res.leftChar = left.leftChar;   
//         res.rightChar = right.rightChar; 
//         res.leftCount = left.leftCount; 
//         if(left.leftCount == left.length && left.rightChar == right.leftChar)
//             res.leftCount = left.length + right.leftCount;

//         res.rightCount = right.rightCount; 
//         if(right.rightCount == right.length && left.rightChar == right.leftChar)
//             res.rightCount = right.length + left.rightCount;

//         res.max = Math.max(left.max, right.max); 
//         if(left.rightChar == right.leftChar)
//             res.max = Math.max(res.max, left.rightCount + right.leftCount); 
//         return res; 
//     }
// }



// piyush
class Solution{
    class Node{
        char leftChar, rightChar;
        int leftCount, rightCount, max, length;
        Node() {}
        Node(char c){
            leftChar  = c; rightChar = c;
            leftCount = 1; rightCount = 1;
            max = 1;
            length = 1;
        }
    }
    Node[] tree; 
    int size;

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices){
        int n = s.length(), q = queryIndices.length;
        size = 1;
        while(size < n) size *= 2;
        tree = new Node[2*size];
        for(int i=0; i<size; i++){
            tree[size+i] = (i<n) ? new Node(s.charAt(i)) : new Node();
        }
        for(int i=size-1; i>=1; i--){
            tree[i] = merge(tree[2*i], tree[2*i+1]);
        }
        int[] ans = new int[q];
        for(int i=0; i<q; i++){
            update(queryIndices[i], queryCharacters.charAt(i));
            ans[i] = tree[1].max;
        } 
        return ans;
    }

    private void update(int pos, char c){
        int idx = pos + size;
        tree[idx] = new Node(c);
        for(idx /= 2; idx >= 1; idx/=2){
            tree[idx] = merge(tree[2*idx], tree[2*idx+1]);
        }
    }

    private Node merge(Node left, Node right){
        if(left.length == 0) return right;
        if(right.length == 0) return left;
        Node res = new Node();
        res.length = left.length + right.length;
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;
        res.leftCount = left.leftCount;
        if(left.leftCount == left.length && left.rightChar == right.leftChar){
            res.leftCount = left.length + right.leftCount;
        } 
        res.rightCount = right.rightCount;
        if(right.rightCount == right.length && left.rightChar == right.leftChar){
            res.rightCount = right.length + left.rightCount;
        }
        res.max = Math.max(left.max, right.max);
        if(left.rightChar == right.leftChar){
            res.max = Math.max(res.max, left.rightCount + right.leftCount);
        }
        return res;
    }
}