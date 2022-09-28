package jingdong;

import java.util.*;


public class Wifi {
    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        int n=sc.nextInt();
        int n=5;
        int[][]loc=new int[][]{{0,1},{1,-10},{1,1},{3,3},{4,1}};
//        for(int i=0;i<n;i++){
//            loc[i][0]=sc.nextInt();
//        }
//        for(int i=0;i<n;i++){
//            loc[i][1]=sc.nextInt();
//        }
        DisjointSetUnion dsu=new DisjointSetUnion(n);
        List<Edge>edges= new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                edges.add(new Edge(ManhattanDist(loc,i,j),i,j));
            }
        }
        Collections.sort(edges, Comparator.comparingInt(o -> o.dist));

        int res=0;
        int num=1;
        for(Edge edge:edges){
            int len=edge.dist,x=edge.x,y=edge.y;
            if(dsu.unionSet(x,y)){
                System.out.println(x+"-"+y+":"+len);
                res=Math.max(res,len);
                num++;
                if(num==n)
                    break;


            }
        }
        System.out.println(Arrays.toString(dsu.f));
        System.out.println(Arrays.toString(dsu.rank));
        System.out.println(res);
    }

    public static int ManhattanDist(int[][]loc, int i, int j){
        return (Math.abs(loc[i][0]-loc[j][0])+Math.abs(loc[i][1]-loc[j][1]));
    }
}

class DisjointSetUnion {
    int[] f;//每个节点的父节点
    int[] rank;//节点排名
    int n;

    public DisjointSetUnion(int n) {
        this.n = n;
        this.rank = new int[n];
        Arrays.fill(this.rank, 1);
        this.f = new int[n];
        for (int i = 0; i < n; i++) {
            this.f[i] = i;
        }
    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

//    判断x和y两个点是否已经被访问过
    public boolean unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return false;
        }
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
        return true;
    }
}

class Edge {
    int dist, x, y;
    public Edge(int dist, int x, int y) {
        this.dist = dist;
        this.x = x;
        this.y = y;
    }
}


