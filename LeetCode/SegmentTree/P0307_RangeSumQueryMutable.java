package LeetCode.Array;

/**
 * Platform: LeetCode
 * Problem ID: 307
 * Problem Name: Range Sum Query Mutable
 * Difficulty: Medium
 * 
 * Link: https://leetcode.com/problems/range-sum-query-mutable/
 * 
 * Complexity:
 * - Time Complexity: O(logn*K)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: Describe your approach here
 */

public class P0307_RangeSumQueryMutable {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0307_RangeSumQueryMutable...");
    }

    // TODO: Write solution method here
}
class NumArray {

    int tree[];
    int arr[];
    int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.tree = new int[4*n];
        this.arr = nums;

        build(0,0,n-1);

    }
    public void build(int root, int l, int r)
    {

        if(l==r)
        {
            tree[root] = arr[l];
            return;
        }
        int mid = l + (r - l)/2;
        build(2*root + 1, l, mid);
        build(2*root + 2, mid + 1, r);
        tree[root] = tree[2*root + 1] + tree[2*root + 2];

    }


    public void update(int index, int val) {

        update(index, val, 0, 0, n-1);

    }
    public void update(int index, int val, int root, int l, int r)
    {

        if(l==r)
        {
            tree[root] = val;
            arr[index] = val;
            return;
        }
        int mid = l + (r - l)/2;

        if(index <= mid)
        {
            update(index, val, 2*root + 1, l, mid);
        }
        else
        {
            update(index, val, 2*root + 2, mid + 1, r);
        }
        tree[root] = tree[2*root + 1] + tree[2*root + 2];

    }

    public int sumRange(int left, int right) {

        return query(left, right, 0, 0, n - 1);

    }
    public int query(int start, int end, int root, int l, int r)
    {
        if(l > end || r < start)
        {
            return 0;
        }
        if(l>=start && r<=end)
        {
            return tree[root];
        }
        int mid = (l + r)/2;

        return query(start,end, 2*root + 1, l, mid) + query(start,end, 2*root + 2, mid + 1, r);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */