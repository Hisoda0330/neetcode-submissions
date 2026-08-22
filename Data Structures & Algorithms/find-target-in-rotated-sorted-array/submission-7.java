class Solution {


    public int search(int[] nums, int target) {
        //first determine which side of the array is sorted -> 
        // inbetween: target > nums[mid] < nums[high] 
        // on the other half: nums[mid] < 
        
        int min = findMin(nums);

        if(target >= nums[min] && target <= nums[nums.length - 1]){
            return binarySearch(nums, target, min, nums.length-1);
        }
        else{
            return binarySearch(nums, target, 0, min -1);
        }

        // if(target > nums[nums.length - 1]){
        //     return binarySearch(nums, target, 0, min - 1);
        // }
        // else{
        //     return binarySearch(nums, target, min, nums.length - 1);
        // }
    }
    
    // find the min of the arr
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

    //standard binary search
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
}

/*core idea: 

find the min inorder to know which side of arr is sorted, then compare the target with the last ele in arr, if > then it must be on the left side of the arr , bounded -> 0 to min - 1; else must be on right side of arr -> bounded min to nums.length - 1;

*/
