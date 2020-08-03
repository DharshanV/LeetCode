import com.sun.source.tree.Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MergeTwoBinaryTrees {
    public static TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return null;

        TreeNode node = new TreeNode();
        if (t1 == null) {        //only tree2 node exists
            node.val = t2.val;
        } else if (t2 == null) { //only tree1 node exists
            node.val = t1.val;
        } else {                    //both nodes exists
            node.val = t1.val + t2.val;
        }

        node.left = mergeTrees((t1 == null) ? null : t1.left, (t2 == null) ? null : t2.left);
        node.right = mergeTrees((t1 == null) ? null : t1.right, (t2 == null) ? null : t2.right);
        return node;
    }

    public static void VLT(TreeNode node) {
        if (node == null) return;
        System.out.println(node.val);
        VLT(node.left);
        VLT(node.right);
    }

    public static void main(String[] args) {
        TreeNode root1 = tree1();
        TreeNode root2 = tree2();

        TreeNode root = mergeTrees(root1, root2);
        VLT(root);
    }

    public static TreeNode tree1() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);

        node1.left = node3;
        node1.right = node2;
        node3.left = node5;

        return node1;
    }

    public static TreeNode tree2() {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);

        node2.left = node1;
        node2.right = node3;
        node1.right = node4;
        node3.right = node7;

        return node2;
    }
}
