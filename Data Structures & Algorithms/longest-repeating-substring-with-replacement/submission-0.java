class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int maxRes = 0;
        HashMap<Character, Integer> count = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            count.put(c,count.getOrDefault(c,0) + 1);
            int mostFrequent = Collections.max(count.values());
            if((i - left + 1) - mostFrequent > k){
                char update = s.charAt(left);
                count.put(update, count.get(update)-1);
                left ++;
            }
            maxRes = Math.max(maxRes, i - left + 1);
        }
        return maxRes;
    }
}