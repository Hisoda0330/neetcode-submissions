class Solution {
    public int trap(int[] height) {
        //simplified version
        int left = 0;
        int right = height.length-1;
        int leftmax = height[left];
        int rightmax = height[right];
        int area =0;
        while(left < right){
            if(leftmax < rightmax){
                left ++;
                leftmax = Math.max(leftmax, height[left]);
                area += leftmax - height[left];
    
            }
            else{
                right--;
                rightmax = Math.max(rightmax, height[right]);
                area += rightmax - height[right];
            }
        }
        return area;
    }
}
