class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        int leftmax = height[0];
        int rightmax = height[right];
        while(left < right){
            int bottleneck = Math.min(leftmax, rightmax);
            //int max = Math.max(height[left], height[right]);
            if(height[left] > bottleneck){
                right--;
                rightmax = Math.max(height[right], rightmax);
                if(height[right] < bottleneck){
                    area += bottleneck - height[right];
                }
            }
            else if(height[right] >= bottleneck){
                left++;
                leftmax = Math.max(height[left], leftmax);
                if(height[left] < bottleneck){
                    area += bottleneck - height[left];
                }
            }
            // else{
            //     left++;
            //     leftmax = Math.max(height[left], leftmax);
            //     if(height[right] < bottleneck){
            //         area += bottleneck - height[left];
            //     }
            // }
        }
        return area;
    }
}
