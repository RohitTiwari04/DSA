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
    int height(TreeNode root){
        if(root == null) return 0;

        return  Math.max(height(root.left) , height(root.right)) +1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);
        
        int curr = height(root.left) + height(root.right);

        return  Math.max(curr , Math.max(ld,rd));
        
    }
}