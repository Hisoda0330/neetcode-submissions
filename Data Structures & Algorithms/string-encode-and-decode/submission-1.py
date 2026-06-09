class Solution:

    def encode(self, strs: List[str]) -> str:
        count = ""
        for ele in strs:
            count += str(len(ele)) + "#" + ele
        return count

    def decode(self, s: str) -> List[str]:
        output = []
        i=0
        while i < len(s):
            j = i
            while s[j] != "#":
                j += 1 
            length = int(s[i:j]) 
            temp = s[j+1 : j+length+1]
            output.append(temp)
            i = j + length + 1
        return output