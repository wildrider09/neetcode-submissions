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

class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {

        solve(root);
        return ans;
    }
    int solve(TreeNode root){
        if(root == null)
            return 0;
        
        int l = solve(root.left);
        int r = solve(root.right);

        int temp = Math.max(root.val, root.val + Math.max(l,r));
        int res = Math.max(temp, root.val + l + r );

        ans = Math.max(ans, res);

        return temp;
    }
}
