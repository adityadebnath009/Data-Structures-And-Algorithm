package LeetCode.Array;

/**
 * Platform: LeetCode
 * Problem ID: 315
 * Problem Name: Count of Smaller Numbers After Self
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * Complexity:
 * - Time Complexity: O(nlogn)
 * - Space Complexity: O(n)
 * 
 * Approach:
 * // TODO: Merge Sort, Extensions of Count of inversion
 */

public class P0315_CountOfSmallerNumbersAfterSelf {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0315_CountOfSmallerNumbersAfterSelf...");
    }

    // TODO: Write solution method here
}
class Solution {
    class Pair
    {
        int value;
        int originalIndx;
        Pair(int value, int originalIndx)
        {
            this.value = value;
            this.originalIndx = originalIndx;
        }
    }
    int ans[];

    void mergeSort(Pair arr[], int low, int high)
    {
        if(low<high)
        {
            int mid = low + (high - low)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);

        }
    }
    void merge(Pair arr[], int low, int mid,  int high)
    {
        int count = 0;

        int n1 = mid - low + 1;
        int n2 = high - mid;

        Pair left[] = new Pair[n1];
        Pair right[] = new Pair[n2];

        int k = low;

        for(int i = 0;i < n1;i++)
        {
            left[i] = arr[k++];
        }
        for(int i = 0;i < n2;i++)
        {
            right[i] = arr[k++];
        }

        int i = 0;
        int j = 0;
        k = low;
        while(i < n1 && j<n2)
        {
            if(left[i].value <= right[j].value)
            {
                ans[left[i].originalIndx] +=count;
                arr[k++] = left[i];
                i++;
            }
            else
            {
                count++;
                arr[k++] = right[j];
                j++;
            }
        }

        while(i<n1)
        {
            ans[left[i].originalIndx] +=count;
            arr[k++] = left[i++];
        }
        while(j < n2)
        {
            arr[k++] = right[j++];
        }
    }
    public List<Integer> countSmaller(int[] a) {
        Pair arr[] = new Pair[a.length];
        ans = new int[a.length];
        for(int i = 0;i < a.length;i++)
        {
            arr[i] = new Pair(a[i],i);
        }
        mergeSort(arr, 0, arr.length - 1);


        List<Integer> res = new ArrayList<>();

        for(int num:ans)
        {
            res.add(num);
        }

        return res;
    }
}