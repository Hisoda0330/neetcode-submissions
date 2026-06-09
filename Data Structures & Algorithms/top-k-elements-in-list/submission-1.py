class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        freq = []
        count = {}
        output =[]
        for i in range(len(nums)+1):
            freq.append([])
        for ele in nums:
            count[ele] = count.get(ele, 0) + 1
        for e, n in count.items():
            freq[n].append(e)
        for i in range(len(freq),0,-1):
            for idx in freq[i-1]:
                output.append(idx)
                if len(output) == k:
                    return output
                
            