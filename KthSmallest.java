// Time complexity: O(nlognlogk) where n is the number of elements in the matrix.
// Space complexity: O(1) since we are not using any additional data structures that grow with input size.

import java.util.PriorityQueue;

public class KthSmallest {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {

            int mid = left + (right - left) / 2;
            int count = getCount(matrix, mid);

            if (count < k)
                left = mid + 1;
            else
                right = mid - 1;
        }

        return left;
    }

    public int getCount(int[][] matrix, int mid) {
        int count = 0;
        int j = matrix.length - 1;

        for (int i = 0; i < matrix.length; i++) {
            while (j >= 0 && matrix[i][j] > mid)
                j--;
            count += j + 1;
        }
        return count;
    }
}

// Time Complexity: O(nlogn) where n is the number of elements in the matrix.
// Space Complexity: O(k) where k is the size of the max heap used to store the
// k smallest elements.

class KthSmallestWithHeap {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                maxHeap.offer(matrix[i][j]);
                if (maxHeap.size() > k) {
                    maxHeap.poll();
                }
            }
        }
        return maxHeap.peek();
    }
}