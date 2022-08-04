package zhousai;
import java.util.*;
public class countExcellentPairs {
    public long countExcellentPairs(int[] nums, int k) {
        long ans=0;
//        Map<Integer,Integer>cnt_map=new HashMap<>();
        HashSet<Integer>vis=new HashSet<>();
        int[]cnts=new int[33];
        for(int num:nums){
            if(vis.contains(num))
                continue;
            int bitSum=Integer.bitCount(num);
            System.out.println(bitSum);
            cnts[bitSum]++;
//            cnt_map.put(bitSum,cnt_map.getOrDefault(bitSum,0)+1);
            vis.add(num);
        }
        int[]bigger_cnts=new int[33];
        bigger_cnts[32]=cnts[32];
        System.out.println(Arrays.toString(cnts));
        for(int i=31;i>=0;i--){
            bigger_cnts[i]=bigger_cnts[i+1]+cnts[i];
        }
        System.out.println(Arrays.toString(bigger_cnts));
        for(int i=0;i<33;i++){
            if(i>=k){
                ans+=cnts[i]*bigger_cnts[0];
            }else if(k-i>32){
                continue;
            }else{
                ans+=cnts[i]*bigger_cnts[k-i];
            }

        }
//        for(Map.Entry<Integer,Integer>entry1:cnt_map.entrySet()){
//            for(Map.Entry<Integer,Integer>entry2:cnt_map.entrySet()){
//                if(entry1.getKey()+entry2.getKey()>=k){
//                    ans+=entry1.getValue()*entry2.getValue();
//                }
//            }
//        }
        return ans;
    }

    public static void main(String[] args) {
        countExcellentPairs countExcellentPairs=new countExcellentPairs();
        System.out.println(countExcellentPairs.countExcellentPairs(new int[]{423436147,29690092,724837828,339900252,819138876,559797269,337577818,347372617,568172510,434046210,233465903,73777015,995100887,952551841,314703814,588503612,5824363,105686599,5167368,154358365,497653021,450975800,431388582,607991479,856148544,982787927,513430676,918344731,98092726,690894469,396191705,848402861,593468334,563155911,715586102,739434236,387304407,927581316,779272764,558853665,215920106,631709145,726054493,415057810,708860839,401596916,795418594,462963799,835785708,670198432,171214014,162179684,27901422,717744871,603604788,664478320,915525044,818068724,564705733,490294265,804021123,688892990,741612165,590640255,535167444,228105610,197887678,963803394,698521654,794863135,712203903,16780599,583378338,927863644,628601885,878322079,632547981,426926648
        },55));
    }
}
