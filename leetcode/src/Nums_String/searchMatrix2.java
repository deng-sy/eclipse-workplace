package Nums_String;
//编写一个高效的算法来搜索?m?x?n?矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。

public class searchMatrix2 {

    public static boolean searchMatrix2(int[][]matrix,int target){
        int height=matrix.length;
        int width=matrix[0].length;
        int left=0,up=0,right=width-1,down=height-1;
        while(left<right||up<down){
            for(int i=left;i<=right;i++){
                if(target==matrix[up][i])
                    return true;
                if(target<matrix[up][i]){
                    right=i-1;
                    break;
                }
            }
            for(int i=up;i<=down;i++){
                if(target==matrix[i][left])
                    return true;
                if(target<matrix[i][left]){
                    down=i-1;
                    break;
                }
            }
            for(int i=left;i<=right;i++){
                if(target==matrix[down][i])
                    return true;
                if(target<matrix[down][i]){
                    left=i;
                    break;
                }
            }
            for(int i=up;i<=down;i++){
                if(target==matrix[i][right])
                    return true;
                if(target<matrix[i][right]){
                    up=i;
                    break;
                }
            }
            if(matrix[up][left]>target||matrix[down][right]<target)
                return false;

        }
        if(matrix[up][left]==target)
            return true;
        return false;
//        while(mid_row>=0&&mid_row<height&&mid_col>=0&&mid_col<=width){
//            if(target==matrix[mid_row][mid_col])
//                return true;
//            else if(target<matrix[mid_row][mid_col]&&(!smallFound)){
//                mid_row--;
//                mid_col--;
//                bigFound=true;
//            }else if(target>matrix[mid_row][mid_col]&&(!bigFound)){
//                mid_row++;
//                mid_col++;
//                smallFound=true;
//            }else if(target<matrix[mid_row][mid_col]&&(smallFound)){
//
//            }
//        }
//        for(int i=0;i<=col;i++){
//            if(matrix[row][i]==target)
//                return true;
//        }
//        for(int i=0;i<=row;i++){
//            if(matrix[i][col]==target)
//                return true;
//        }

    }

    public static void main(String[] args) {
//        int[][]matrix={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        int[][]matrix={{-5}};
        int target=-5;
        System.out.println(searchMatrix2(matrix,target));
    }
}
