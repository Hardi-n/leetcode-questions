/*
 * 4. Median of Two Sorted Arrays
 * Hard
 * Topics
 * Companies
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * Constraints:
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 */



 class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Use a list to add elements, then convert to an array later
        HashSet<Integer> set = new HashSet<>();
        
        // Add elements from both arrays to the HashSet
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            set.add(num);
        }

        // Convert the set to an array
        int[] mainarr = new int[set.size()];
        int index = 0;
        for (int num : set) {
            mainarr[index++] = num;
        }

        // Sort the array
        Arrays.sort(mainarr);
        // double addition=0;
        // for(int i=0;i<mainarr.length;i++){
        //     addition=addition+mainarr[i];
        // }
        // return addition/mainarr.length;
        int n = mainarr.length;
        if (n % 2 == 0) {
            return (mainarr[n/2 - 1] + mainarr[n/2]) / 2.0;
        } else {
            return mainarr[n/2];
        }
    }
}



/*
 * 
 * Approach
 * 
 * 1. create a hashset to store the every non-duplicate element of both arrays.
 * 2. create a new array of that hashset and sort it using Arrays.sort()
 * 3. Find median using n%2==0 then (arr[n/2-1] + arr[n/2+1])/2 or else arr[n/2]
 */


 /*updated code -------------------->>>>>>>>>>>>>>>>>>> */
 class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int[] mergedArray = new int[n1 + n2];
        
        // Merge the two arrays
        for(int i=0;i<n1;i++){
            mergedArray[i]=nums1[i];
        }
        for(int i=0 ;i<n2;i++){
            mergedArray[n1+i]=nums2[i];
        }
        
        // Sort the merged array
        Arrays.sort(mergedArray);
        
        // Calculate the median
        int totalLength = mergedArray.length;
        if (totalLength % 2 == 0) {
            return (mergedArray[totalLength/2 - 1] + mergedArray[totalLength/2]) / 2.0;
        } else {
            return mergedArray[totalLength/2];
        }
    }
}


/*
 * 
 * Approach used is without hashmap 
 * 1. because single array can have duplicate elements which will eventually change the median
 */