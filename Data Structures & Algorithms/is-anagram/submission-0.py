class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        HashS, HashT = {}, {}
        if len(s) != len(t):
            return False
        for i in range(len(s)):
            HashS[s[i]] = 1 + HashS.get(s[i] , 0)
            HashT[t[i]] = 1 + HashT.get(t[i] , 0)
        for c in HashS:
            if (HashS[c] != HashT.get(c, 0)):
                return False
        return True