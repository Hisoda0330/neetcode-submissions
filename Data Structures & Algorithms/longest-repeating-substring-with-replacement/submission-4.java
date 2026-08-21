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
//core idea:: for each input, record the read value into a hashmap. check if window shrink is needed by comparing if subtracting the length by the most frequent char in the window > replacement k, then shrink window by ++ left ponter.
}

//max = Collections.max(map.values()); -> O(26 * n)
/* while(right - left + 1) - max > k  
shrink left pointer
-> left++ 

maxsize = max(maxsize, current window length -> right - left + 1)
*/