class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> one = new HashMap<>();
        HashMap<Character, Integer> two = new HashMap<>();
        
        if(s1.length() > s2.length()){
            return false;
        }

        for(int i = 0; i < s1.length(); i++){
            char a = s1.charAt(i);
            one.put(a, one.getOrDefault(a,0) + 1);
        }

        int left = 0;

        for(int j = 0; j < s2.length(); j++){
            char b = s2.charAt(j);
            two.put(b, two.getOrDefault(b,0)+1);

            if(j - left + 1 > s1.length()){
                char c = s2.charAt(left);
                two.put(c, two.get(c) - 1);
                //remove if 0, so we can compare correctly
                if(two.get(c) == 0){
                    two.remove(c);
                }
                left++;
            }

            if(one.equals(two)){
                return true;
            }
            
        }
        return false;
    }
}
//use of hashmap to record the appearance of each char, order doesnt matter here so we just need to see the same number of appearance of s1 in s2.