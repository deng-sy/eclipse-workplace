package huawei;

import tencent.ListNode;

import java.util.*;
public class NumsClassification{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[]I=new int[n];
        for(int i=0;i<n;i++){
            I[i]=sc.nextInt();
        }
        int m=sc.nextInt();
        Set<Integer>set=new TreeSet<>();
        for(int i=0;i<m;i++){
            set.add(sc.nextInt());
        }
        int cnt=set.size();
        Map<Integer,Set<Integer>>map=new HashMap<>();

        for(int i=0;i<n;i++){
            int num=I[i];
            String str=String.valueOf(num);
            for(Iterator<Integer>it=set.iterator();it.hasNext();){
                int match_num=it.next();
                String match=String.valueOf(match_num);
                if(str.contains(match)){
                    if(map.get(match_num)==null){
                        map.put(match_num,new TreeSet<>());
                    }
                    map.get(match_num).add(i);
                }
            }
//            while(num!=0){
//                int digit=num%10;
//                if(set.contains(digit)){
//                    if(map.get(digit)==null){
//                        map.put(digit,new HashSet<>());
//                    }
//                    map.get(digit).add(i);
//                }
//                num/=10;
//            }
        }
        int total_num=map.keySet().size()*2;
        for(Iterator<Integer>it=map.keySet().iterator();it.hasNext();){
            int key=it.next();
            total_num+=map.get(key).size()*2;
        }
        System.out.print(total_num+" ");
        for(Iterator<Integer>it=set.iterator();it.hasNext();){
            int key=it.next();
            if(map.get(key)==null)
                continue;
            int size=map.get(key).size();
            System.out.print(key+" "+size+" ");
            for(Iterator<Integer>it1=map.get(key).iterator();it1.hasNext();){
                int idx=it1.next();
                System.out.print(idx+" "+I[idx]+" ");
            }
        }



    }
}
