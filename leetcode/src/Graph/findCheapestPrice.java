package Graph;
//�� n ������ͨ��һЩ�������ӡ�����һ������?flights ������?flights[i] = [fromi, toi, pricei] ����ʾ�ú��඼�ӳ��� fromi ��ʼ���Լ۸� pricei �ִ� toi��
//
//���ڸ������еĳ��кͺ��࣬�Լ��������� src ��Ŀ�ĵ� dst������������ҵ���һ����ྭ�� k?վ��ת��·�ߣ�ʹ�ô� src �� dst �� �۸������ �������ظü۸� ���������������·�ߣ������ -1��

import java.util.ArrayList;
import java.util.*;

public class findCheapestPrice {
//    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
//        final int INF=Integer.MAX_VALUE/n;
//        int[][]g=new int[n][n];
//        for(int i=0;i<n;i++){
//            Arrays.fill(g[i],INF);
//        }
//        for(int[]flight:flights){
//            int x=flight[0],y=flight[1],price=flight[2];
//            g[x][y]=price;
//        }
//        int[]cost=new int[n];
//        Arrays.fill(cost,INF);
//        cost[src]=0;
//        boolean[]used=new boolean[n];
//        List<Map<Integer,Integer>> list=new ArrayList<>();
//        for(int i=0;i<n;i++){
//            list.add(new HashMap<>());
//        }
//        list.get(src).put(0,0);
//        for(int i=0;i<n;i++){
//            int x=-1;
//            for(int y=0;y<n;y++){
//                if(!used[y]&&(!list.get(y).isEmpty()))
//                    x=y;
//            }
//            used[x]=true;
//            Map<Integer,Integer>tmp_x=list.get(x);
//            Set<Integer>steps=tmp_x.keySet();
//            for(int y=0;y<n;y++){
//                if(g[x][y]==INF)
//                    continue;
//                Map<Integer,Integer>tmp_y=list.get(y);
//                for(int step:steps){
//                    if(step>k)
//                        continue;
//                    if(tmp_y.get(step+1)!=null&&tmp_x.get(step)+g[x][y]>=tmp_y.get(step+1))
//                        continue;
//                    tmp_y.put(step+1,tmp_x.get(step)+g[x][y]);
//                }
//            }
//        }
//        Map<Integer,Integer>res=list.get(dst);
//        int min_price=INF;
//        for(int price:res.values()){
//            min_price=Math.min(min_price,price);
//        }
//        return min_price==INF?-1:min_price;
//    }
    static final int INF=Integer.MAX_VALUE/2;
    static int[]dist=new int[100];
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k){
        Arrays.fill(dist,INF);
        dist[src]=0;
        for(int limit=0;limit<k+1;limit++){
            int[]clone=dist.clone();
            for(int[]flight:flights){
                int x=flight[0],y=flight[1],w=flight[2];
                dist[y]=Math.min(dist[y],clone[x]+w);
            }
        }
        return dist[dst]==INF?-1:dist[dst];
    }
    public static void main(String[] args) {
        int[][]flights={{0,1,5},{1,2,5},{0,3,2},{1,4,1},{3,1,2},{4,2,1}};
        int n=5,src=0,dst=2,k=2;
        System.out.println(findCheapestPrice(n,flights,src,dst,k));
    }
}
