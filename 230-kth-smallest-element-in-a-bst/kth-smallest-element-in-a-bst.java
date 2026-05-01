class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    int count = 0;
    int answer = 0;

    public int kthSmallest(TreeNode root, int k) {

        inorder(root, k);

        return answer;
    }

    private void inorder(TreeNode node, int k) {

        if (node == null) {
            return;
        }

        // Visit left subtree
        inorder(node.left, k);

        // Visit current node
        count++;

        if (count == k) {
            answer = node.val;
            return;
        }

        // Visit right subtree
        inorder(node.right, k);
    }
}