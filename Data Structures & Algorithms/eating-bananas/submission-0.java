class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // needs to find the length, largest value, and how to connect it with h inorder to find k?
        //1. find the max in the arr, 2. use binary search in speed, k. where 0 > k < max
        
        int max = 0;
        //find max in arr
        for(int num : piles){
            max = Math.max(max, num);
        }
        
        //use binary search to find min of speed
        int res = 0;
        int low = 1;
        int high = max;

        while(low <= high){
            int total = 0;
            int mid = low + ((high - low) / 2);
            // mid = 1 + (12) = 13
            // mid = 14 + 5 = 19
            // mid = 20 + 2 = 22
            // mid = 23 + 1 = 24
            // mid = 24 + 0 = 24
            // mid = 25
            for(int i : piles){
                // (i - 1) / mid + 1  => finding ceiling
                total += Math.ceil((double)i / mid);
                
                //t = 2 + 1 + 2 + 1 = 6 > h=4
                //t = 2 + 1 + 2 + 1 = 6 > h=4
                // == 6 > 4
                // t = 2 + 1 + 1 + 1 = 5 > h=4
                // t = 5 > 4
                // t = 1 + 1 + 1 + 1 = 4 == h=4
            }
            
            if(total <= h){
                res = mid;
                high = mid - 1;
            }

            else if(total > h){
                low = mid + 1;
                //low = 14
                //low = 20
                //low = 23
                //low = 24
                //low = 25
            }


        }
        return res;
    }
}
