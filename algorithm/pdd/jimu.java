package pdd;
import java.util.*;
public class jimu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int n=in.nextInt(),m=in.nextInt();
            List<List<Integer>>lists= new ArrayList<>();
            for(int j=0;j<m;j++){
                int cnt=in.nextInt();
                List<Integer>list=new ArrayList<>();
                for(int k=0;k<cnt;k++){
                    list.add(in.nextInt());
                }
                lists.add(list);
            }
            boolean find;
            while(!isEmpty(lists)){
                find=false;
                loop:
                for(List<Integer> list1:lists){
                    for(List<Integer> list2:lists){
                        if(list1!=list2&&list1.get(list1.size()-1)!=list1.get(list1.size()-1)){
                            list1.remove(list1.size()-1);
                            list2.remove(list2.size()-1);
                            find=true;
                            break loop;
                        }
                    }
                }
                if(!find)
                    break;

            }
            if(isEmpty(lists))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
    private static boolean isEmpty(List<List<Integer>>lists){
        for(List<Integer>list:lists){
            if(!list.isEmpty())
                return false;
            else
                lists.remove(list);
        }
        return true;
    }
}