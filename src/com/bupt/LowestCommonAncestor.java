package com.bupt;


/*
*
* Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.


*
*
*
* */

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root == null || root == p || root == q)
            return root;
        TreeNode l = lowestCommonAncestor(root.left, p ,q);
        TreeNode r = lowestCommonAncestor(root.right, p ,q);
        return l == null? r: r == null? l : root;
    }

}
