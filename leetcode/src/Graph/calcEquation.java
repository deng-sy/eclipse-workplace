package Graph;
import java.util.*;
// 给定一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。
//另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。
//返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。

public class calcEquation {

//    法一：深度优先
    public double[] calcEquation1(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int nvars=0;
        Map<String,Integer>vars=new HashMap<>();
        int n=equations.size();
        for(int i=0;i<n;i++){
            if(!vars.containsKey(equations.get(i).get(0)))
                vars.put(equations.get(i).get(0),nvars++);
            if(!vars.containsKey(equations.get(i).get(1)))
                vars.put(equations.get(i).get(1),nvars++);
        }
        List<Pair>[]edges=new List[nvars];
        for(int i=0;i<nvars;i++){
            edges[i]=new ArrayList<>();
        }
        for(int i=0;i<n;i++){
            int va=vars.get(equations.get(i).get(0));
            int vb=vars.get(equations.get(i).get(1));
            edges[va].add(new Pair(vb,values[i]));
            edges[vb].add(new Pair(va,1/values[i]));
        }
        int cnt=queries.size();
        double[]ret=new double[cnt];
        for(int i=0;i<cnt;i++){
            List<String>query=queries.get(i);
            double res=-1.0;
            if(vars.containsKey(query.get(0))&&vars.containsKey(query.get(1))){
                int ia=vars.get(query.get(0));
                int ib=vars.get(query.get(1));
                if(ia==ib)
                    res=1.0;
                else{
                    Queue<Integer>points=new LinkedList<>();
                    points.offer(ia);
                    double[]ratios=new double[nvars];
                    Arrays.fill(ratios,-1.0);
                    ratios[ia]=1.0;
                    while(!points.isEmpty()&&ratios[ib]<0){
                        int x=points.poll();
                        for(Pair pair:edges[x]){
                            int y=pair.idx;
                            double val=pair.val;
                            if(ratios[y]<0){
                                ratios[y]=ratios[x]*val;
                                points.offer(y);
                            }
                        }
                    }
                    res=ratios[ib];
                }
            }
            ret[i]=res;
        }
        return ret;
    }
    class Pair{
        int idx;
        double val;
        Pair(int idx,double val){
            this.idx=idx;
            this.val=val;
        }
    }
//    法二：Floyd算法
    public double[] calcEquation2(List<List<String>> equations, double[] values, List<List<String>> queries){
        int nvars=0;
        Map<String,Integer>vars=new HashMap<>();
        int n=equations.size();
        for(int i=0;i<n;i++){
            if(!vars.containsKey(equations.get(i).get(0)))
                vars.put(equations.get(i).get(0),nvars++);
            if(!vars.containsKey(equations.get(i).get(1)))
                vars.put(equations.get(i).get(1),nvars++);
        }
        double[][]graph=new double[nvars][nvars];
        for(int i=0;i<nvars;i++)
            Arrays.fill(graph[i],-1.0);
        for(int i=0;i<n;i++){
            int va=vars.get(equations.get(i).get(0));
            int vb=vars.get(equations.get(i).get(1));
            graph[va][vb]=values[i];
            graph[vb][va]=1.0/values[i];
        }
        for(int k=0;k<nvars;k++){
            for(int i=0;i<nvars;i++){
                for(int j=0;j<nvars;j++){
                    if(graph[i][k]>0&&graph[k][j]>0)
                        graph[i][j]=graph[i][k]*graph[k][j];
                }
            }
        }
        int cnt=queries.size();
        double[]ret=new double[cnt];
        for(int i=0;i<cnt;i++){
            List<String>query=queries.get(i);
            double res=-1.0;
            if(vars.containsKey(query.get(0))&&vars.containsKey(query.get(1))){
                int ia=vars.get(query.get(0));
                int ib=vars.get(query.get(1));
                if(graph[ia][ib]>0)
                    res=graph[ia][ib];
            }
            ret[i]=res;
        }
        return ret;
    }
//    法三：带权并查集
    public double[] calcEquation3(List<List<String>> equations, double[] values, List<List<String>> queries){
        int nvars=0;
        Map<String,Integer>vars=new HashMap<>();
        int n=equations.size();
        for(int i=0;i<n;i++){
            if(!vars.containsKey(equations.get(i).get(0)))
                vars.put(equations.get(i).get(0),nvars++);
            if(!vars.containsKey(equations.get(i).get(1)))
                vars.put(equations.get(i).get(1),nvars++);
        }
        int[]f=new int[nvars];
        double[]w=new double[nvars];
        Arrays.fill(w,1.0);
        for(int i=0;i<nvars;i++)
            f[i]=i;
        for(int i=0;i<n;i++){
            int va=vars.get(equations.get(i).get(0));
            int vb=vars.get(equations.get(i).get(1));
            merge(f,w,va,vb,values[i]);
        }
        int cnt=queries.size();
        double[]ret=new double[cnt];
        for(int i=0;i<cnt;i++){
            List<String>query=queries.get(i);
            double res=-1.0;
            if(vars.containsKey(query.get(0))&&vars.containsKey(query.get(1))){
                int ia=vars.get(query.get(0));
                int ib=vars.get(query.get(1));
                int fa=find(f,w,ia);
                int fb=find(f,w,ib);
                if(fa==fb)
                    res=w[ia]/w[ib];
            }
            ret[i]=res;
        }
        return ret;
    }
    public void merge(int[]f,double[]w,int x,int y,double val){
        int fx=find(f,w,x);
        int fy=find(f,w,y);
        f[fx]=fy;
        w[fx]=val*w[y]/w[x];
    }
    public int find(int[]f,double[]w,int x){
        if(f[x]!=x){
            int father=find(f,w,f[x]);
            w[x]=w[x]*w[f[x]];
            f[x]=father;
        }
        return f[x];
    }

}
