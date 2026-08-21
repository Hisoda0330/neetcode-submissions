class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        //record the need
        for(int i = 0; i < t.length(); i++){
            char a = t.charAt(i);
            needMap.put(a, needMap.getOrDefault(a,0) + 1);
        }
        
        int left = 0 , resleft = 0;
        int need = needMap.size();
        int have = 0;
        int reslen = Integer.MAX_VALUE;
        //scan to find string 
        HashMap<Character, Integer> window = new HashMap<>();
        for(int right = 0; right < s.length(); right++){

            char b = s.charAt(right);

            window.put(b,window.getOrDefault(b,0)+1); //record

            if(window.get(b).equals(needMap.get(b))){
                have++;
            }

            while(have == need){

                int foundlen = right - left + 1; //substring size
                
                if(foundlen < reslen){
                    resleft = left;
                    reslen = foundlen;
                }

                window.put(s.charAt(left), window.getOrDefault(s.charAt(left),0) - 1);

                if(needMap.containsKey(s.charAt(left)) && window.get(s.charAt(left)) <
                                    needMap.get(s.charAt(left))){
                    have--;
                }

                left ++;
            }
        }

        if(reslen == Integer.MAX_VALUE){
            return "";
        }
        else{
            return s.substring(resleft, resleft + reslen);
        }

    }

//core idea: record t into a hashmap; move the right pointer until the need and have equals in string s, then shrink the pointer from left to find min window. if shrink causes have != need, keep moving the left window and repeat.
}
// create two hashmap, record the need: t. and for each char read in the s, if is the char we need, record it. if the substring we scan is == need, update the length of the string, then we move the shrink the window by moving left pointer until need != have. 
// when found new min substring, remember to update the left pointer, if the left pointer -> char is in need, also update the count in need.
