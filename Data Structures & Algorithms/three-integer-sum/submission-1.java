class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        Arrays.sort(nums);
        int left_value, right_value;
        //prevent fixed i to be the same , if nums[i] = nums[i-1] -> duplicate triples
        for(int i = 0; i < nums.length - 2; i++){  //IMPROVE: i < nums.length - 2 -> left and right will have no valid pair if i at second- to last index
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            //OPTIONAL IMPROVE: since sorted, if value at fixed i is > 0, then no sum can add up to 0
            if(nums[i] > 0){
                break;
            }
            //each iteration: left and right updates according with i
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
