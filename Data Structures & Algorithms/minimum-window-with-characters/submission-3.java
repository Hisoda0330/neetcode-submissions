class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> needMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            char a = t.charAt(i);
            needMap.put(a, needMap.getOrDefault(a,0) + 1);
        }
        
        int left = 0 , resleft = 0;
        int need = needMap.size();
        int have = 0;
        int reslen = Integer.MAX_VALUE;
        HashMap<Character, Integer> window = new HashMap<>();
        for(int right = 0; right < s.length(); right++){

            char b = s.charAt(right);

            window.put(b,window.getOrDefault(b,0)+1);

            if(window.get(b).equals(needMap.get(b))){
                have++;
            }

            while(have == need){

                int found = right - left + 1;

                if(found < reslen){
                    resleft = left;
                    reslen = found;
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
}
