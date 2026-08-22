class Solution {
    public int findMin(int[] nums) {
        // brute force: o(n)
        // binary : o(log n)
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

        return nums[low];
    }
}
/* core idea: 
keep comparing the mid to the high, if less than or equal, the min must be itself or on the left.
if greater than, then the min must be on the right, then low = mid + 1.
then eventually with while(low < high), it will shrink down to one integer where low == high, and thats the min.
*/
