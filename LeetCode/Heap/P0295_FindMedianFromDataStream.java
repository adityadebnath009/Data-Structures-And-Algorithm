/**
 * Platform: LeetCode
 * Problem ID: 295
 * Problem Name: Find Median from Data Stream
 * Difficulty: Hard
 * 
 * Link: https://leetcode.com/problems/find-median-from-data-stream/
 * 
 * Complexity:
 * - Time Complexity: O(N)
 * - Space Complexity: O(1)
 * 
 * Approach:
 * // TODO: We maintain a max heap and a mean heap.
 * The max heap stores the smaller half of the elements,
 * and the mean heap stores the larger half.
 * We ensure that every element in the max heap is less than or equal to every element in the min heap,
 * and that the size difference between the two heaps never exceeds one.
 * The max heap may contain one more element than the mean heap when the total number of elements is odd;
 * in that case we return the top of the max heap as the median.
 * When both heaps have the same number of elements,
 * the total number of elements is even,
 * and we compute the median as the average of the two top elements. This is the approach.
 */

public class P0295_FindMedianFromDataStream {
    public static void main(String[] args) {
        // Write test cases here
        System.out.println("Running P0295_FindMedianFromDataStream...");
    }

    // TODO: Write solution method here
}
class MedianFinder {

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();



    public MedianFinder() {

    }

    public void addNum(int num) {
        if(maxHeap.size()==0 || maxHeap.peek()>num)
        {
            maxHeap.add(num);
        }
        else
        {
            minHeap.add(num);
        }

        if(maxHeap.size()>minHeap.size() + 1)
        {
            minHeap.add(maxHeap.poll());
        }
        else if(minHeap.size() > maxHeap.size())
        {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
        {
            return (maxHeap.peek() + minHeap.peek())/2.0;
        }
        return maxHeap.peek();


    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */