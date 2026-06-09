class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        Hashs, Hasht = {},{}
        if len(s) != len(t):
            return False;
        for i in range(len(s)):
            Hashs[s[i]] = 1 + Hashs.get(s[i], 0)
            Hasht[t[i]] = 1 + Hasht.get(t[i], 0)
        if Hashs == Hasht:
            return True
        return False