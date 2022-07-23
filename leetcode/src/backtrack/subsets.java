package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//����һ�鲻���ظ�Ԫ�ص��������� nums�����ظ��������п��ܵ��Ӽ����ݼ�����
public class subsets {
    public static List<List<Integer>> subsets(int[]nums){
        List<List<Integer>>list=new ArrayList<>();
//        Arrays.sort(nums);
        backtrack(list,new ArrayList<>(),nums,0);
        return list;
    }

    private static void backtrack(List<List<Integer>>list,List<Integer>tmpList,int[]nums,int start){
        list.add(new ArrayList<>(tmpList));
        for(int i=start;i<nums.length;i++){
            tmpList.add(nums[i]);
            backtrack(list,tmpList,nums,i+1);
            tmpList.remove(tmpList.size()-1);
        }
    }

    public static void main(String[] args) {
        int[]nums={1,2,3};
        System.out.println(subsets(nums));
    }
}
