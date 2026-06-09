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
            count =""
            temp = ""
            while s[j] != "#":
                count += s[j]
                j += 1
            for k in range(int(count)):
                j += 1
                temp += s[j]
            output.append(temp)
            i=j+1
        return output