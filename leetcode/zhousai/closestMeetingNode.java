package zhousai;

import java.util.Arrays;

public class closestMeetingNode {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[]dist1=getDist(edges,node1),dist2=getDist(edges,node2);
        int minDist=Integer.MAX_VALUE;
        int ans=-1;
        for(int i=0;i<edges.length;i++){
            if(dist1[i]>=0&&dist2[i]>=0){
                int dist=Math.max(dist1[i],dist2[i]);
                if(dist<minDist){
                    minDist=dist;
                    ans=i;
                }
            }
        }
        return ans;
    }
    private int[]getDist(int[]edges,int node){
        int[]ret=new int[edges.length];
        Arrays.fill(ret,-1);
        ret[node]=0;
        int target;
        while(edges[node]!=-1){
            target=edges[node];
            if(ret[target]>=0)
                break;
            ret[target]=ret[node]+1;
            node=target;
        }
        return ret;
    }
}
