package zhousai;
//���һ�������ξ����������� ȫ�� ���������֮Ϊһ�� X ���� ��
//
//����Խ����ϵ�����Ԫ�ض� ���� 0
//��������������Ԫ�ض��� 0
//����һ����СΪ n x n �Ķ�ά�������� grid ����ʾһ�������ξ������ grid ��һ�� X ���� ������ true �����򣬷��� false ��
public class checkMatrix {
    public static boolean checkXMatrix(int[][] grid) {
        int n=grid.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j||i==n-1-j){
                    if(grid[i][j]==0||grid[i][j]==0)
                        return false;
                }else
                    if(grid[i][j]>0)
                        return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][]grid={{5,7,0},{0,3,1},{0,5,0}};
        System.out.println(checkXMatrix(grid));
    }
}
