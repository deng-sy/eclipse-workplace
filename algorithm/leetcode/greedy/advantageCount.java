package greedy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

//给定两个大小相等的数组A和B，A相对于B的优势可以用满足A[i]>B[i]的索引i的数目来描述。返回A的任意排列，使其相对于B的优势最大化。
public class advantageCount {
    public static int[]advantageCount(int[]nums1,int[] nums2){
        int length=nums1.length;
        int []res=new int[length];
        Arrays.sort(nums1);
//        构建最大堆，将nums2元素降序排列
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->b[0]-a[0]);
        for(int i=0;i<length;i++)
            pq.add(new int[]{nums2[i],i});
//        System.out.println(pq);
        int left=0,right=length-1;
        while(!pq.isEmpty()){
            int[]cur=pq.poll();
            int idx=cur[1];
            int val=cur[0];
            if(nums1[right]>val)
                res[idx]=nums1[right--];
            else
                res[idx]=nums1[left++];

        }
        return res;
    }
    public static void main(String[] args) {
        int[]a={1,3,5},b={2,4,6};
        System.out.println(Arrays.toString(advantageCount(a,b)));

    }
}

