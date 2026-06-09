class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        res = defaultdict(list)
        for word in strs:
            key = [0] * 26
            for s in word:
                key[ord(s) - ord('a') ] += 1
            res[tuple(key)].append(word)
        return list(res.values())