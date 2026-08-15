class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        // Skip duplicate fixed values to avoid duplicate triplets.
        for(int i = 0; i < nums.length - 1; i++){  //IMPROVE: i < nums.length - 2 -> Need at least two numbers after i for left and right.
            
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //OPTIONAL IMPROVE: Since nums is sorted, all future values are positive, so no triplet can sum to 0.
            if(nums[i] > 0){
                break;
            }
            //each iteration: left and right updates according with i
            int left = i + 1, right = nums.length-1;

            //loop thru to find pairs
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i]; //Recompute sum after each pointer movement.

                //since sorted, if sum < 0, we need to increase the sum, and left pointer goes right will increase the sum
                if(sum < 0){
                    left ++;
                }
                //since sorted, if sum > 0, we need to decrease the sum, and right pointer goes left will decrease the sum
                else if(sum > 0){
                    right --;
                }
                //Found one valid triplet; skip duplicate left/right values before continuing.
                else{
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    int left_value = nums[left];
                    int right_value = nums[right];

                    left++;
                    right--;

                    //Skip duplicate left and right values.
                    while(left < right && nums[left] == left_value){
                        left++;
                    }
                    while(left < right && nums[right] == right_value){
                        right--;
                    }
                }
            }
        }
        return output;
    }
}
