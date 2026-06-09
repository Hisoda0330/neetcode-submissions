class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        hashnum = {}
        for i in range(len(nums)):
            diff = target - nums[i]
            if (diff in hashnum):
                return([min(i, hashnum[diff]), max(i, hashnum[diff])])
            hashnum[nums[i]] = i
            