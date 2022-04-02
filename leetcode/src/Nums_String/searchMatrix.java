package Nums_String;
//编写一个高效的算法来判断?m x n?矩阵中，是否存在一个目标值。该矩阵具有如下特性：
//
//每行中的整数从左到右按升序排列。
//每行的第一个整数大于前一行的最后一个整数。

public class searchMatrix {
    public static boolean searchMatrix(int[][] matrix, int target){
        int height=matrix.length;
        int width=matrix[0].length;
        int total=height*width;
        int left=0,right=total-1;
        while(left<=right){
            int mid=(right-left)/2+left;
            int row=mid/width,col=mid%width;
            if(matrix[row][col]>target)
                right=mid-1;
            else if(matrix[row][col]<target)
                left=mid+1;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][]matrix={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        int target=23;
        System.out.println(searchMatrix(matrix,target));
    }
}