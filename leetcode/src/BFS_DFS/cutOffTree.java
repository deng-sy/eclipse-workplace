package BFS_DFS;
import java.util.*;
//你被请来给一个要举办高尔夫比赛的树林砍树。树林由一个?m x n 的矩阵表示， 在这个矩阵中：
//
//0 表示障碍，无法触碰
//1?表示地面，可以行走
//比 1 大的数?表示有树的单元格，可以行走，数值表示树的高度
//每一步，你都可以向上、下、左、右四个方向之一移动一个单位，如果你站的地方有一棵树，那么你可以决定是否要砍倒它。
//
//你需要按照树的高度从低向高砍掉所有的树，每砍过一颗树，该单元格的值变为 1（即变为地面）。
//
//你将从 (0, 0) 点开始工作，返回你砍完所有树需要走的最小步数。 如果你无法砍完所有的树，返回 -1 。
//
//可以保证的是，没有两棵树的高度是相同的，并且你至少需要砍倒一棵树。
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

