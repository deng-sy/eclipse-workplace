package Nums_String;
//编写一个高效的算法来搜索?m?x?n?矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：

//每行的元素从左到右升序排列。
//每列的元素从上到下升序排列。

public class searchMatrix2 {

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                ++x;
            }
        }
        return false;


    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
//        int[][]matrix={{-5}};
        int target = 19;
        System.out.println(searchMatrix2(matrix, target));
    }
}
