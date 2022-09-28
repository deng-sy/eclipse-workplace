package pdd;
import java.util.*;
public class Dice {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Map<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<n;i++){
            int val=0;
            int[]nums=new int[6];
            int front=0;
            for(int j=0;j<6;j++){
                nums[j]=sc.nextInt();
                if(nums[j]==1)
                    front=j;
            }
            if(front%2==0)
                val=nums[(front+2)%6]*1000+nums[(front+4)%6]*100+nums[(front+3)%6]*10+nums[(front+5)%6];
            else
                val=nums[(front+1)%6]*1000+nums[(front+4)%6]*100+nums[(front+2)%6]*10+nums[(front+3)%6];
            for(int k=0,tmp=val;k<3;k++){
                tmp=tmp/10+(tmp%10*1000);
                val=Math.min(val,tmp);
            }
            map.put(val,map.getOrDefault(val,0)+1);
        }
        int cnt=map.keySet().size();
        List<Integer>ret=new ArrayList<>();
        for(Iterator<Integer>it=map.keySet().iterator();it.hasNext();){
            ret.add(map.get(it.next()));
        }
        Collections.sort(ret,Collections.reverseOrder());
        System.out.println(cnt);
        for(int i=0;i<cnt;i++){
            System.out.println(ret.get(i));
        }
    }
}
