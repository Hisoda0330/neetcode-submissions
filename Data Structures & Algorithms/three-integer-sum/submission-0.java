class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int left_value, right_value;
        for(int i = 0; i < nums.length - 1; i++){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int left = i+1, right = nums.length-1;
            
            while(left < right){
                int sum = nums[left] + nums[right] + nums[i];
                if(sum < 0){
                    left ++;
                }
                else if(sum > 0){
                    right --;
                }
                else{
                    output.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left_value = nums[left];
                    right_value = nums[right];
                    left++;
                    right--;
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
