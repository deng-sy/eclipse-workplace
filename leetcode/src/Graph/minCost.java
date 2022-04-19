package Graph;
//һ�������� n?�����У����б��Ϊ?0?��?n - 1?����Ŀ��֤ ���г���?����˫���· ������һ��?����·�ɶ�ά��������?edges?��ʾ������?edges[i] = [xi, yi, timei]?��ʾ����?xi ��?yi?֮����һ��˫���·���ķ�ʱ��Ϊ?timei?���ӡ���������֮����ܻ��ж����ķ�ʱ�䲻ͬ�ĵ�·�����ǲ����е�·��ͷ������ͬһ�����С�
//ÿ�ξ���һ������ʱ������Ҫ��ͨ�зѡ�ͨ�з���һ������Ϊ n?���±�� 0?��ʼ����������?passingFees?��ʾ������?passingFees[j]?���㾭������ j?��Ҫ֧���ķ��á�
//һ��ʼ�����ڳ���?0?������Ҫ�� maxTime?��������?������ maxTime?���ӣ��������?n - 1?�����е� ���� Ϊ�㾭�������г��� ͨ�з�֮��?������?�����յ���е�ͨ�зѣ���
//����?maxTime��edges?��?passingFees?�����㷵��������е�?��С����?������޷���?maxTime?��������������У����㷵��?-1?��
import java.util.Arrays;
public class minCost {
    final int INF=Integer.MAX_VALUE/2;
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n=passingFees.length;
        int[][]f=new int[maxTime+1][n];//f[t][i] ��ʾʹ��ǡ�� t���ӵ������ i��Ҫ������ͨ�з��ܺ͡�
        for(int t=0;t<=maxTime;t++)
            Arrays.fill(f[t],INF);
        f[0][0]=passingFees[0];
        for(int t=1;t<=maxTime;t++){
            for(int[]edge:edges){
                int i=edge[0],j=edge[1],cost=edge[2];
                if(cost<=t){
                    f[t][i]=Math.min(f[t][i],f[t-cost][j]+passingFees[i]);
                    f[t][j]=Math.min(f[t][j],f[t-cost][i]+passingFees[j]);
                }
            }
        }
        int res=INF;
        for(int t=1;t<=maxTime;t++)
            res=Math.min(res,f[t][n-1]);
        return res==INF?-1:res;
    }
}
