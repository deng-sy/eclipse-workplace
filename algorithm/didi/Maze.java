package didi;

import java.util.*;
public class Maze {
    static class Path{
        int[]pos;
        Path pre;
        public Path(int[] pos, Path pre) {
            this.pos = pos;
            this.pre = pre;
        }
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt(),m=sc.nextInt(),p=sc.nextInt();
            int[][]maze=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    maze[i][j]=sc.nextInt();
                }
            }
            int[][]power=new int[n][m];
            for(int i=0;i<n;i++)
                Arrays.fill(power[i],Integer.MAX_VALUE);
            power[0][0]=0;
            PriorityQueue<Path>queue=new PriorityQueue<>(Comparator.comparingInt(a->power[a.pos[0]][a.pos[1]]));
            Path start=new Path(new int[]{0,0},null);
            queue.offer(start);
            int[][]dirs={{-1,0,3},{1,0,0},{0,1,1},{0,-1,1}};
            Path[][]paths=new Path[n][m];
            paths[0][0]=start;
            while(!queue.isEmpty()){
                int size=queue.size();
                for(int i=0;i<size;i++){
                    Path pre=queue.poll();
                    int[]pos=pre.pos;
                    int x=pos[0],y=pos[1];
                    for(int[]dir:dirs){
                        int nx=x+dir[0],ny=y+dir[1];
                        if(nx>=0&&nx<n&&ny>=0&&ny<m&&maze[nx][ny]>0&&power[x][y]+dir[2]<power[nx][ny]){
                            if(paths[nx][ny]==null){
                                paths[nx][ny]=new Path(new int[]{nx,ny},pre);
                                queue.offer(paths[nx][ny]);
                            }else
                                paths[nx][ny].pre=pre;
                            power[nx][ny]=power[x][y]+dir[2];

                        }
                    }
                }
            }
            System.out.println(power[0][m-1]);
            if(power[0][m-1]>p)
                System.out.println("Can not escape!");
            else{
                StringBuilder sb=new StringBuilder();
                Path end=paths[0][m-1];
                while(end!=start){
                    sb.append("]"+end.pos[1]+","+end.pos[0]+"["+",");
                    end=end.pre;
                }
                sb.append("]"+start.pos[1]+","+start.pos[0]+"[");
                System.out.println(sb.reverse());
            }

        }
    }
}
