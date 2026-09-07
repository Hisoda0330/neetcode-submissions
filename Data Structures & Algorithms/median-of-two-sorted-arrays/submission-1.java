class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int total_size = nums1.length + nums2.length;
        int[] merge = new int[total_size];
        
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < nums1.length && j < nums2.length){
            if(nums1[i] > nums2[j]){
                merge[k] = nums2[j];
                j++;
                k++;
            }else{
                merge[k] = nums1[i];
                i++;
                k++;
            }
        }

        while(i < nums1.length){
            merge[k] = nums1[i];
            k++;
            i++;
        }

        while(j < nums2.length){
            merge[k] = nums2[j];
            k++;
            j++;
        }

        if(total_size % 2 == 0){
            double median = (merge[total_size/2 - 1] + merge[total_size / 2]) / 2.0;
            return median;
        }
        else{
            double median = merge[total_size/2];
            return median;
        }
        
        
        
    }
}
