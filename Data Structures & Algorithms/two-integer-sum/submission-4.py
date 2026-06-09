class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        HashOrder = {}
        for i in range(len(nums)):
            counter = target - nums[i]
            if counter in HashOrder:
                return [HashOrder[counter], i]
            HashOrder[nums[i]] = i