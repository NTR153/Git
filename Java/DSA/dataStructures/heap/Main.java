package dataStructures.heap;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /* findKthSmallest
        
        int[] nums1 = {7, 10, 4, 3, 20, 15};
        int k1 = 3;
        System.out.println("Test case 1:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums1, k1));
        System.out.println();

        // Test case 2
        int[] nums2 = {2, 1, 3, 5, 6, 4};
        int k2 = 2;
        System.out.println("Test case 2:");
        System.out.println("Expected output: 2");
        System.out.println("Actual output: " + findKthSmallest(nums2, k2));
        System.out.println();

        // Test case 3
        int[] nums3 = {9, 3, 2, 11, 7, 10, 4, 5};
        int k3 = 5;
        System.out.println("Test case 3:");
        System.out.println("Expected output: 7");
        System.out.println("Actual output: " + findKthSmallest(nums3, k3));
        System.out.println();
        */

        /* streamMax

        int[] nums1 = {1, 5, 2, 9, 3, 6, 8};
        System.out.println("Test case 1:");
        System.out.println("Input: [1, 5, 2, 9, 3, 6, 8]");
        System.out.println("Expected output: [1, 5, 5, 9, 9, 9, 9]");
        System.out.println("Actual output: " + streamMax(nums1));
        System.out.println();
    
        // Test case 2
        int[] nums2 = {10, 2, 5, 1, 0, 11, 6};
        System.out.println("Test case 2:");
        System.out.println("Input: [10, 2, 5, 1, 0, 11, 6]");
        System.out.println("Expected output: [10, 10, 10, 10, 10, 11, 11]");
        System.out.println("Actual output: " + streamMax(nums2));
        System.out.println();
    
        // Test case 3
        int[] nums3 = {3, 3, 3, 3, 3};
        System.out.println("Test case 3:");
        System.out.println("Input: [3, 3, 3, 3, 3]");
        System.out.println("Expected output: [3, 3, 3, 3, 3]");
        System.out.println("Actual output: " + streamMax(nums3));
        System.out.println();
         */
    }

    public static int findKthSmallest(int[] nums, int k) {
        Heap maxHeap = new Heap();
        for (int i: nums) {
            maxHeap.insert(i);
        }
        for (int i=0; i<nums.length-k; i++) {
            maxHeap.remove();
        }
        return maxHeap.getHeap().get(0);
    }

    // public static int findKthSmallest(int[] nums, int k) {   // Udemy Solution
    //     Heap maxHeap = new Heap();
    //     for (int num : nums) {
    //         maxHeap.insert(num);
    //         if (maxHeap.getHeap().size() > k) {
    //             maxHeap.remove();
    //         }
    //     }
    //     return maxHeap.remove();
    // }

    // Implement a function named streamMax that processes a stream of integers 
    // and returns the maximum number encountered so far for each input number.

    public static List<Integer> streamMax(int[] nums) {
        Heap maxHeap = new Heap();
        List<Integer> maxStream = new ArrayList<>();
 
        for (int num : nums) {
            maxHeap.insert(num);
            // The heap's root is always the maximum, so we add it to the result list
            maxStream.add(maxHeap.getHeap().get(0));
        }
 
        return maxStream;
    }
}