class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //use binary search:
        int top = matrix.length - 1;
        int bot = 0;
        int end_cols = matrix[0].length - 1;

        while(bot <= top){

            int mid = bot + ((top - bot) / 2);

            if(matrix[mid][0] <= target && matrix[mid][end_cols] >= target){

                int i_top = end_cols;
                int i_bot = 0;

                while(i_bot <= i_top){

                    int i_mid = i_bot + ((i_top - i_bot) / 2);
                    if(matrix[mid][i_mid] == target){
                        return true;
                    }
                    else if(matrix[mid][i_mid] > target){
                        i_top = i_mid - 1;
                    }
                    else if(matrix[mid][i_mid] < target){
                        i_bot = i_mid + 1;
                    }
                }
                return false;
            }
            else if(matrix[mid][0] > target){
                top = mid - 1;
            }
            else if(matrix[mid][end_cols] < target){
                bot = mid + 1;
            }
        }

        return false;
    }
}
