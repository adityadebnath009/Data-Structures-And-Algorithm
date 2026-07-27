package LeetCode.Trees;

/**
 * Platform: LeetCode
 * Problem ID: 2385
 * Problem Name: Amount of Time for Binary Tree to Be Infected
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P2385_AmountOfTimeForBinaryTreeToBeInfected {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P2385_AmountOfTimeForBinaryTreeToBeInfected...");
    }

    // TODO: Write solution method here
}

class Solution {
    public void buildParentMapping(HashMap<TreeNode, TreeNode> parent, TreeNode root, TreeNode par)
    {
        if(root==null)
        {
            return;
        }

        if(par!=null)
        {
            parent.put(root, par);
        }
        buildParentMapping(parent, root.left,root);
        buildParentMapping(parent, root.right, root);

    }
    public TreeNode findNode(TreeNode root, int start)
    {
        if(root==null)
        {
            return null;
        }

        if(root.val==start)
        {
            return root;
        }

        TreeNode left = findNode(root.left, start);
        TreeNode right = findNode(root.right, start);

        TreeNode find = null;

        if(left!=null)
        {
            find = left;
        }

        if(right!=null)
        {
            find = right;
        }

        return find;
    }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        buildParentMapping(parent, root,null);



        TreeNode startNode = findNode(root, start);

        int time = bfs(parent, startNode);


        return time;





    }
    public int bfs(HashMap<TreeNode, TreeNode> parent, TreeNode start)
    {
        Set<TreeNode> set = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();

        int time = 0;

        set.add(start);
        q.add(start);

        while(!q.isEmpty())
        {
            int size = q.size();

            while(size-->0)
            {
                TreeNode currNode = q.poll();

                if(currNode.left!=null && !set.contains(currNode.left))
                {
                    set.add(currNode.left);
                    q.add(currNode.left);
                }
                if(currNode.right!=null && !set.contains(currNode.right))
                {
                    set.add(currNode.right);
                    q.add(currNode.right);
                }
                TreeNode p = parent.getOrDefault(currNode,null);
                if(p!=null && !set.contains(p))
                {
                    set.add(p);
                    q.add(p);
                }
            }
            time++;
        }

        return time - 1;
    }
}
