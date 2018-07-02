package com.bupt;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuffer sb = preOrderTraversal(root, new StringBuffer());
        String str = sb.toString();
        return str.substring(0, str.length() - 1);
    }

    private StringBuffer preOrderTraversal(TreeNode root, StringBuffer sb) {
        if(root == null) {
            sb.append("#,");
        } else {
            sb.append(root.val + ",");
            sb = preOrderTraversal(root.left, sb);
            sb = preOrderTraversal(root.right , sb);
        }
        return sb;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] str = data.split(",");

        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));

        TreeNode root = doDeserialize(queue);

        return root;

    }
    private TreeNode doDeserialize(Queue<String> q) {

        String value = q.poll();
        if(value.equals("#")) {
            return null;
        } else {

            TreeNode root = new TreeNode(Integer.valueOf(value));
            root.left = doDeserialize(q);
            root.right = doDeserialize(q);
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
