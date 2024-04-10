package dataStructures.heap;

public class Main {
    public static void main(String[] args) {
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
}