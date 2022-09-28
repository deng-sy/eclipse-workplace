package Graph;
//现在总共有 numCourses?门课需要选，记为?0?到?numCourses-1。
//
//给定一个数组?prerequisites ，它的每一个元素?prerequisites[i]?表示两门课程之间的先修顺序。?例如?prerequisites[i] = [ai, bi]?表示想要学习课程 ai?，需要先完成课程 bi?。
//
//请根据给出的总课程数 ?numCourses 和表示先修顺序的?prerequisites?得出一个可行的修课序列。
//
//可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。

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
