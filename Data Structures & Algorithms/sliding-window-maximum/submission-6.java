class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //windows moves each iteration. 
        //1. maybe can store max for each time window slides and compare incoming int
        //but how to deal with the max that is out of window after updates//////
        //2.store with a deque in order, so when the max is out of the window, next max = new max
        //each time dq.peekLast() 
        /*

        Function	        Meaning
        dq.offerLast(x)	    add to back
        dq.pollLast()	    remove from back
        dq.peekLast()	    look at back
        dq.offerFirst(x)	add to front
        dq.pollFirst()	    remove from front
        dq.peekFirst()	    look at front
        dq.isEmpty()	    check empty
        dq.size()	        size

        */

        Deque<Integer> storemax = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int left = 0;
        int resIndex = 0;
        for(int right = 0; right < nums.length; right++){

            while(!storemax.isEmpty() && nums[right] > nums[storemax.peekLast()]){

                storemax.pollLast();   
            }

            storemax.offerLast(right);


            while(right - left + 1 > k){
                if(storemax.peekFirst() == left){
                    storemax.pollFirst();
                }
                left++;
            }
            
            if(right - left + 1 == k){
                res[resIndex] = nums[storemax.peekFirst()];
                resIndex++;
            }

        }
        return res;
    }
}
