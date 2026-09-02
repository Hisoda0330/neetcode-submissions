class TimeMap {


    private Map<String, List<Pair>> store;

    //class for Pair so can use later on in the list 
    private static class Pair{
        String value;
        int timestamp;
        
        Pair(String value, int timestamp){
            this.value = value;
            this.timestamp = timestamp;
        }
    }

    public TimeMap() {

        store = new HashMap<>();

    }
    
    public void set(String key, String value, int timestamp) {
        if(!store.containsKey(key)){
            store.put(key, new ArrayList<>());
        }
        store.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        
        List<Pair> value = store.getOrDefault(key, Collections.emptyList());

        String result = "";
        int left = 0;
        int right = value.size() - 1;
        
        //use standard binary search
        while(left <= right){
            int mid = left + (right - left) / 2;
            
            //ans on the right bc timestamp larger than mid
            if(value.get(mid).timestamp <= timestamp){
                result = value.get(mid).value;
                left = mid + 1;
            }//else would be on the left bc timestamp smaller than mid
            else{
                right = mid - 1;
            }
         }

         return result;
         
    }
}
