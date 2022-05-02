package Graph;
//�����ܹ��� numCourses?�ſ���Ҫѡ����Ϊ?0?��?numCourses-1��
//
//����һ������?prerequisites ������ÿһ��Ԫ��?prerequisites[i]?��ʾ���ſγ�֮�������˳��?����?prerequisites[i] = [ai, bi]?��ʾ��Ҫѧϰ�γ� ai?����Ҫ����ɿγ� bi?��
//
//����ݸ������ܿγ��� ?numCourses �ͱ�ʾ����˳���?prerequisites?�ó�һ�����е��޿����С�
//
//���ܻ��ж����ȷ��˳��ֻҪ���ⷵ��һ�־Ϳ����ˡ����������������пγ̣�����һ�������顣

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class findOrder {
    List<List<Integer>>edges=new ArrayList<>();
    int[]indegs;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        indegs=new int[numCourses];
        for(int i=0;i<numCourses;i++)
            edges.add(new ArrayList<>());
        for(int[]prerequisite:prerequisites){
            edges.get(prerequisite[1]).add(prerequisite[0]);
            indegs[prerequisite[0]]++;
        }
        Queue<Integer>queue=new LinkedList<>();
        int[]res=new int[numCourses];
        int idx=0;
        for(int i=0;i<numCourses;i++){
            if(indegs[i]==0)
                queue.offer(i);
        }
        while(!queue.isEmpty()){
            int i=queue.poll();
            res[idx++]=i;
            for(int j:edges.get(i)){
                indegs[j]--;
                if(indegs[j]==0)
                    queue.offer(j);
            }
        }
        if(idx!=numCourses)
            return new int[0];
        return res;
    }
}
