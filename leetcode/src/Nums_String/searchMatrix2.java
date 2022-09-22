package Nums_String;
//��дһ����Ч���㷨������?m?x?n?���� matrix �е�һ��Ŀ��ֵ target ���þ�������������ԣ�

//ÿ�е�Ԫ�ش������������С�
//ÿ�е�Ԫ�ش��ϵ����������С�

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
