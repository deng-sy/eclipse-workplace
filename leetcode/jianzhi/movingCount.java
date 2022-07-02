package jianzhi;
//������һ��m��n�еķ��񣬴����� [0,0] ������ [m-1,n-1] ��һ�������˴����� [0, 0] ��
// ���ӿ�ʼ�ƶ�����ÿ�ο��������ҡ��ϡ����ƶ�һ�񣨲����ƶ��������⣩��Ҳ���ܽ�������
// ������������λ֮�ʹ���k�ĸ��ӡ����磬��kΪ18ʱ���������ܹ����뷽�� [35, 37] ����
// Ϊ3+5+3+7=18���������ܽ��뷽�� [35, 38]����Ϊ3+5+3+8=19�����ʸû������ܹ��������
// ������

import java.util.LinkedList;
import java.util.Queue;

public class movingCount {
    public int movingCount(int m, int n, int k) {
        if(k==0)
            return 1;
        Queue<int[]>queue=new LinkedList<>();
        int[][]dirs={{1,0},{-1,0},{0,1},{0,-1}};
        boolean[][]vis=new boolean[m][n];
        vis[0][0]=true;
        queue.offer(new int[]{0,0});
        int ans=1;
        while(!queue.isEmpty()){
            int[]cell=queue.poll();
            int x=cell[0],y=cell[1];
            for(int[]dir:dirs){
                int newx=x+dir[0],newy=y+dir[1];
                if(newx<0||newx>=m||newy<0||newy>=n||vis[newx][newy])
                    continue;
                vis[newx][newy]=true;
                if(check(newx,newy,k)){
                    queue.offer(new int[]{newx,newy});
                    ans++;
                }

            }
        }
        return ans;
    }
    private int getBitCnt(int num){
        int cnt=0;
        while(num!=0){
            cnt+=num%10;
            num/=10;
        }
        return cnt;
    }
    private boolean check(int x,int y,int k){
        return getBitCnt(x)+getBitCnt(y)<=k;
    }

}
