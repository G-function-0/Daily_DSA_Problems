//LEETCODE solution

/*
Approach : simple use the concept of same tree Q 100 is different way 
    root1.left must be same as root2.right 
    and root1.right must be same as root2.left
    Because of Mirro Property Draw and mirro and think about it 

*/


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
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
    }

    public static boolean isMirror(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        else if(root1 == null || root2 == null){
            return false;
        }

        if(root1.val != root2.val){
            return false;
        }

        boolean leftcheck = isMirror(root1.left,root2.right);
        boolean rightcheck =  isMirror(root1.right, root2.left);

        return leftcheck && rightcheck;
        
    }
}