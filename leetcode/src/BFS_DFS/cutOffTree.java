package BFS_DFS;
import java.util.*;
//�㱻������һ��Ҫ�ٰ�߶�����������ֿ�����������һ��?m x n �ľ����ʾ�� ����������У�
//
//0 ��ʾ�ϰ����޷�����
//1?��ʾ���棬��������
//�� 1 �����?��ʾ�����ĵ�Ԫ�񣬿������ߣ���ֵ��ʾ���ĸ߶�
//ÿһ�����㶼�������ϡ��¡������ĸ�����֮һ�ƶ�һ����λ�������վ�ĵط���һ��������ô����Ծ����Ƿ�Ҫ��������
//
//����Ҫ�������ĸ߶ȴӵ���߿������е�����ÿ����һ�������õ�Ԫ���ֵ��Ϊ 1������Ϊ���棩��
//
//�㽫�� (0, 0) �㿪ʼ�����������㿳����������Ҫ�ߵ���С������ ������޷��������е��������� -1 ��
//
//���Ա�֤���ǣ�û���������ĸ߶�����ͬ�ģ�������������Ҫ����һ������
public class cutOffTree {
    int[][]dirs={{-1,0},{1,0},{0,-1},{0,1}};
    List<List<Integer>>forest;
    int row,col;
    public int cutOffTree(List<List<Integer>>forest){
        this.forest=forest;
        List<int[]>trees=new ArrayList<>();
        row=forest.size();
        col=forest.get(0).size();
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(forest.get(i).get(j)>1)
                    trees.add(new int[]{i,j});
            }
        }
        Collections.sort(trees, Comparator.comparingInt(a -> forest.get(a[0]).get(a[1])));
        int cx=0,cy=0,ans=0;
        for(int[]tree:trees){
            int steps=bfs(cx,cy,tree[0],tree[1]);
            if(steps==-1)
                return -1;
            ans+=steps;
            cx=tree[0];
            cy=tree[1];
        }
        return ans;
    }
    public int bfs(int sx,int sy,int tx,int ty){
        if(sx==tx&&sy==ty)
            return 0;
        int step=0;
        Queue<int[]>queue=new ArrayDeque<>();
        boolean[]vis=new boolean[row*col];
        queue.offer(new int[]{sx,sy});
        vis[sx*col+sy]=true;
        while(!queue.isEmpty()){
            step++;
            int sz=queue.size();
            for(int i=0;i<sz;i++){
                int[]cell=queue.poll();
                int cx=cell[0],cy=cell[1];
                for(int[]dir:dirs){
                    int nx=cx+dir[0],ny=cy+dir[1];
                    if(nx>=0&&nx<row&&ny>=0&&ny<col){
                        if(!vis[nx*col+ny]&&forest.get(nx).get(ny)>0){
                            if(nx==tx&&ny==ty)
                                return step;
                            queue.offer(new int[]{nx,ny});
                            vis[nx*col+ny]=true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}

