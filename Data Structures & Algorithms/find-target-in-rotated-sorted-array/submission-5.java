class Solution {
        private int findMin(int[] nums){
            
        int res = -1;
        int low = 0;
        int high = nums.length - 1;

        while(low < high){
            int mid = low + ((high - low) / 2);
            
            if(nums[mid] > nums[high]){
                low = mid + 1;

            }
            else if(nums[mid] <= nums[high]){
                high = mid;
            }
        }
        return low;
    }
        private int binarySearch(int[]nums, int target, int low, int high){
        while(low <= high){
            int mid = low + (high - low) / 2;
            
            if(nums[mid] == target){
                return mid;
            }
            else if (nums[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        //first determine which side of the array is sorted -> 
        // inbetween: target > nums[mid] < nums[high] 
        // on the other half: nums[mid] < 
        
        int min = findMin(nums);

        // if(target >= nums[min] && target <= nums[nums.length - 1]){
        //     return binarySearch(nums, target, min, nums.length-1);
        // }
        // else{
        //     return binarySearch(nums, target, 0, min -1);
        // }

        if(target > nums[nums.length - 1]){
            return binarySearch(nums, target, 0, min - 1);
        }
        else{
            return binarySearch(nums, target, min, nums.length - 1);
        }
    }
}
