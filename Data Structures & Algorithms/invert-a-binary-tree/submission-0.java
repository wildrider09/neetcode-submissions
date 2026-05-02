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
    public TreeNode invertTree(TreeNode root) {

       TreeNode temp = root;
       invert(temp);

       return root;
    }

    public TreeNode invert(TreeNode root){
        if(root == null)
            return null;
        if(root.left ==null && root.right == null )
            return root;
        root.left = invert(root.left);
        root.right = invert(root.right);

        TreeNode temp = root.left ;
        root.left  = root.right;
        root.right = temp;

        return root;
    }
}
