class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();
        
        for(String word : strs){
            int[] key = new int[26];
            for(char s : word.toCharArray()){
                key[s - 'a']++;
            }
            String k = Arrays.toString(key);
            if(!res.containsKey(k)){
                res.put(k, new ArrayList<>());
            }
            res.get(k).add(word);
        }

        return new ArrayList<>(res.values());
    }
}
