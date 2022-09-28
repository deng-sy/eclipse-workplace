package huawei;
import java.util.*;
public class Points24{
    static boolean find=false;
    static String ans;
    static int[]nums;
    static String[]cards;
    static String[]pokers={"","A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        System.out.println(getResult(str));

    }
    private static String getResult(String str){
        List<String>list=new ArrayList();
        for(String poker:pokers){
            list.add(poker);
        }
        cards=str.split(" ");
        nums=new int[4];
        for(int i=0;i<4;i++){
            int num=list.indexOf(cards[i]);
            if(num==-1)
                return "ERROR";
            nums[i]=num;
        }
        permute(0,new int[4],new String[4],new boolean[4]);
        if(find)
            return ans;
        return "NONE";


    }
    private static void permute(int idx,int[]new_nums,String[]new_cards,boolean[]vis){
        if(find)
            return;
        if(idx==4){
            calculate(new StringBuilder(),0,0,new_nums,new_cards);
            return;
        }
        for(int j=0;j<4;j++){
            if(vis[j]||(j>0&&nums[j]==nums[j-1]&&!vis[j-1]))
                continue;
            new_nums[idx]=nums[j];
            new_cards[idx]=cards[j];
            vis[j]=true;
            permute(idx+1,new_nums,new_cards,vis);
            vis[j]=false;

        }
    }
    private static void calculate(StringBuilder sb,int idx,int res,int[]array,String[]cards){
        if(find)
            return;
        if(idx==4){
            if(res==24){
                ans=sb.toString();
                find=true;
            }
            return;

        }
        int signIdx=sb.length();
        if(idx>0)
            sb.append('#');
        int val=array[idx];
        sb.append(cards[idx]);
        if(idx==0)
            calculate(sb,idx+1,val,array,cards);
        else{
            sb.setCharAt(signIdx,'+');
            calculate(sb,idx+1,res+val,array,cards);
            sb.setCharAt(signIdx,'-');
            calculate(sb,idx+1,res-val,array,cards);
            sb.setCharAt(signIdx,'*');
            calculate(sb,idx+1,res*val,array,cards);
            sb.setCharAt(signIdx,'/');
            calculate(sb,idx+1,res/val,array,cards);
        }
        sb.setLength(signIdx);

    }

}
