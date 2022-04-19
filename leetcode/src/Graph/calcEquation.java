package Graph;
import java.util.*;
// ����һ������������ equations ��һ��ʵ��ֵ���� values ��Ϊ��֪���������� equations[i] = [Ai, Bi] �� values[i] ��ͬ��ʾ��ʽ Ai / Bi = values[i] ��ÿ�� Ai �� Bi ��һ����ʾ�����������ַ�����
//����һЩ������ queries ��ʾ�����⣬���� queries[j] = [Cj, Dj] ��ʾ�� j �����⣬���������֪�����ҳ� Cj / Dj = ? �Ľ����Ϊ�𰸡�
//���� ��������Ĵ� ���������ĳ���޷�ȷ���Ĵ𰸣����� -1.0 �������𰸡���������г����˸�������֪������û�г��ֵ��ַ�����Ҳ��Ҫ�� -1.0 �������𰸡�

public class calcEquation {

//    ��һ���������
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
//    ������Floyd�㷨
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
//    ��������Ȩ���鼯
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
