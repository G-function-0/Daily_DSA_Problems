//LEETCODe solution : https://leetcode.com/problems/binary-tree-postorder-traversal/description/


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


// PostOrder traversal -> Recursion
// class Solution {
//     public List<Integer> postorderTraversal(TreeNode root) {
//             List<Integer> l = new LinkedList<>();
//             postOrder(l,root);
//             return l;
//     }

//     public static void postOrder(List<Integer> l, TreeNode root){
//         if(root == null){
//             return;
//         }

//         postOrder(l,root.left);
//         postOrder(l,root.right);
//         l.add(root.val);
//     }
// }