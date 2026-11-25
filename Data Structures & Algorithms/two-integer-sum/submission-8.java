class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> table = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            int counter = target - nums[i];
            if(table.containsKey(counter)){
                return new int[]{table.get(counter), i};
            }
            table.put(nums[i],i);
        }
        return new int[]{};
    }
}
