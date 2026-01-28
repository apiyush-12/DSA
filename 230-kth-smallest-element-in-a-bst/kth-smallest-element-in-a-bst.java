/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// class Solution {
//     public ArrayList<Integer> inOrder(TreeNode root, ArrayList<Integer> arr){
//         if(root==null){
//             return arr;
//         }
//         inOrder(root.left, arr);
//         arr.add(root.val);
//         inOrder(root.right, arr);
//         return arr;
//     }
//     public int kthSmallest(TreeNode root, int k) {
//         ArrayList<Integer> nums=inOrder(root, new ArrayList<Integer>());
//         return nums.get(k-1);
//     }
// }

// class Solution{
//     int count=0;
//     int ans=0;
//     public int kthSmallest(TreeNode root, int k){
//         helper(root, k);
//         return ans;
//     }
//     public void helper(TreeNode root, int k){
//         if(root==null){
//             return;
//         }
//         if(count>=k){
//             return;
//         }
//         helper(root.left, k);
//         count=count+1;
//         if(count==k){
//             ans=root.val;
//             return;
//         }
//         helper(root.right, k);
//     }
// }

class Solution{
    int count=0;
    int ans=0;
    public int kthSmallest(TreeNode root, int k){
        helper(root, k);
        return ans;
    }
    public void helper(TreeNode root, int k){
        if(root==null){
            return;
        }
        if(count>=k){
            return;
        }
        helper(root.left, k);
        count=count+1;
        if(count==k){
            ans=root.val;
            return;
        }
        helper(root.right, k);
    }

}