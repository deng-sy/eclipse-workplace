package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//��i���˵�����Ϊpeople[i]��ÿ�Ҵ����Գ��ص��������Ϊl imit��ÿ�Ҵ�����ͬʱ�����ˣ�����������Щ�˵�����֮�����Ϊl imit��
public class numRescueBoats {
    public static List<List<Integer>> numRescueBoats(int[]people, int limit){
        int cnt=0,left=0,right=people.length-1;
        List<List<Integer>>res=new ArrayList<>();

        Arrays.sort(people);
        while(left<=right){
            List<Integer>boat=new ArrayList<>();
            if(people[right]+people[left]<=limit)
                boat.add(people[left++]);
            boat.add(people[right--]);
            res.add(boat);
            cnt++;


        }
        return res;
    }
    public static void main(String[] args) {
        int[]people={3,2,2,1};
        int limit=3;
        System.out.println(numRescueBoats(people,limit));
    }
}
