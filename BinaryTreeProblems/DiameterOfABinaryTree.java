//LEETCOde solution 
//Approach : simple as e calculate height
        // first calculate height of left and height of right then simply check if 
        // dia < left+right+1;
        

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
    static int dia = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dia = -1;
        diameter(root);
        return dia;
    }
    public static int diameter(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = diameter(root.left)+1;
        int right = diameter(root.right)+1;
        if(dia < left+right-2){
            dia = left+right-2;
        }
        return Math.max(left,right);
    }
}
