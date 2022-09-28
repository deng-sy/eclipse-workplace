package Graph;

public class findRedundantConnection {
    int[]parents;
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parents=new int[n];
        for(int i=0;i<n;i++){
            parents[i]=i;
        }
        for(int[]edge:edges){
            int first=edge[0]-1,second=edge[1]-1;
            if(find(first)!=find(second))
                merge(first,second);
            else
                return edge;
        }
        return new int[2];
    }
    public void merge(int i,int j){
        parents[find(i)]=find(j);
    }
    public int find(int i){
        if(parents[i]!=i){
            parents[i]=find(parents[i]);
        }
        return parents[i];
    }
}
