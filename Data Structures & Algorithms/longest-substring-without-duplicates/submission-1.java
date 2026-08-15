class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> charSet = new HashSet<>();
        int max = 0;
        int l = 0;
        for(int i = 0; i < s.length(); i++){
            while(charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(i));
            max = Math.max(max, charSet.size());
        }
        return max;
    }
}
