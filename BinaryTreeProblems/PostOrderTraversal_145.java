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
//Post order using 2 Stack
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> l = new LinkedList<>();
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            if(root == null){
                return l;
            }
            s1.push(root);
            while(!s1.isEmpty()){
                TreeNode curr = s1.pop();
                if(curr.left != null){
                    s1.push(curr.left);
                }
                if(curr.right != null){
                    s1.push(curr.right);
                }
                s2.push(curr);
            }
            while(!s2.isEmpty()){
                l.add(s2.pop().val);
            }
            return l;
    }

}


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