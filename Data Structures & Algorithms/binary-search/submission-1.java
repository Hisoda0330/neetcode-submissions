class Solution {
    public int search(int[] nums, int target) {
        //[1,2,4,4,5,6,7,8,9,10]
        //[0,1,2,3,4,5,6,7,8, 9]
        //array is sorted in increasing order. need to search, find the target return its index, otherwise -1
        int low = 0, high = nums.length - 1;

        while(low <= high){
            int mid = low + ((high - low) / 2);
            if(target == nums[mid]){
                return mid;
            }
            //target at the right side of the array
            else if(target > nums[mid]){
                low = mid + 1;
            }
            //target at left side
            else if(target < nums[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }
}
