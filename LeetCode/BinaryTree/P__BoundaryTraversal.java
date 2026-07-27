package LeetCode.BinaryTree;

/**
 * Platform: LeetCode
 * Problem ID: 
 * Problem Name: Boundary Traversal
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/boundary-traversal/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(N)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P__BoundaryTraversal {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P__BoundaryTraversal...");
    }

    // TODO: Write solution method here
}
class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here

        ArrayList<Integer> result = new ArrayList<>();

        if(root==null)
            return result;

        result.add(root.data);
        if(root.left==null && root.right==null)
        {
            return result;
        }

        ArrayList<Integer> leftEdge = new ArrayList<>();
        leftTraversal(root.left, leftEdge);

        ArrayList<Integer> rightEdge = new ArrayList<>();
        rightTraversal(root.right, rightEdge);
        Collections.reverse(rightEdge);

        ArrayList<Integer> leafs = new ArrayList<>();
        leafTraversal(root.left, leafs);
        leafTraversal(root.right, leafs);

        result.addAll(leftEdge);
        result.addAll(leafs);
        result.addAll(rightEdge);

        return result;



    }

    public void leftTraversal(Node root, ArrayList<Integer> leftEdge)
    {
        if(root==null)
            return;

        if(root.left==null && root.right==null)
        {
            return;
        }

        leftEdge.add(root.data);

        if(root.left!=null)
        {
            leftTraversal(root.left, leftEdge);
        }
        else if(root.right!=null)
        {
            leftTraversal(root.right, leftEdge);
        }


    }

    public void rightTraversal(Node root, ArrayList<Integer> rightEdge)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            return;
        }

        rightEdge.add(root.data);

        if(root.right!=null)
        {
            rightTraversal(root.right, rightEdge);
        }
        else if(root.left!=null)
        {
            rightTraversal(root.left, rightEdge);
        }
    }
    public void leafTraversal(Node root, ArrayList<Integer> leafs)
    {
        if(root==null)
        {
            return;
        }
        if(root.left==null && root.right==null)
        {
            leafs.add(root.data);
            return;
        }
        leafTraversal(root.left, leafs);
        leafTraversal(root.right, leafs);
    }
}