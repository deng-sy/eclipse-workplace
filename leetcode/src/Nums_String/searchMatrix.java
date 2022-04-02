package Nums_String;
//��дһ����Ч���㷨���ж�?m x n?�����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ�
//
//ÿ���е����������Ұ��������С�
//ÿ�еĵ�һ����������ǰһ�е����һ��������

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