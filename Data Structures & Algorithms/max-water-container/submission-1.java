class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int area, res = 0;
        while(left < right){
            area = Math.min(heights[left],heights[right]) * (right - left);
            res = Math.max(res,area);

            if(heights[left] > heights[right]){
                right--;
            }else{
                left ++;
            }
        }
        return res;
    }
}
