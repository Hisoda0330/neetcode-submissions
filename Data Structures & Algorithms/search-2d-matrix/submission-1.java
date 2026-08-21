class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //use binary search:

        int top = matrix.length - 1;
        int bot = 0;
        int end_cols = matrix[0].length - 1;

        while(bot <= top){

            int mid = bot + ((top - bot) / 2);
            //target is within the current array
            if(matrix[mid][0] <= target && matrix[mid][end_cols] >= target){

                int i_top = end_cols;
                int i_bot = 0;
                
                while(i_bot <= i_top){

                    int i_mid = i_bot + ((i_top - i_bot) / 2);
                    //found
                    if(matrix[mid][i_mid] == target){
                        return true;
                    }
                    //target in first half
                    else if(matrix[mid][i_mid] > target){
                        i_top = i_mid - 1;
                    }
                    //target in last half
                    else if(matrix[mid][i_mid] < target){
                        i_bot = i_mid + 1;
                    }
                }
                return false;
            }
            //if first is larger than target -> target must be in earlier of matrix
            else if(matrix[mid][0] > target){
                top = mid - 1;
            }
            //if end is smaller than target -> target must be in later of matrix
            else if(matrix[mid][end_cols] < target){
                bot = mid + 1;
            }
        }
        return false;
    }
}
/*
cored idea: avoid infinite loop, if target is found within a range of array, but there is not target value inside, remember to return false.
Also know when to update the top and bot. such: 
since already in non-decreasing order,
if first of array is larger than target, it must be in earlier of matrix,
if end of array is smaller than target, it must be in later of matrix. 

*/ 
