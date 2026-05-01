class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (root != null) {

            // If both nodes are smaller, move left
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
            }

            // If both nodes are greater, move right
            else if (p.val > root.val && q.val > root.val) {
                root = root.right;
            }

            // Split point found
            else {
                return root;
            }
        }

        return null;
    }
}