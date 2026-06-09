class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [1] * len(nums)
        preffix = 1
        for i in range(len(nums)):
            res[i] = preffix
            preffix = preffix * nums[i]
        suffix = 1
        for i in range(len(nums)-1,-1,-1):
            res[i]= res[i]*suffix
            suffix = nums[i] * suffix
        return res