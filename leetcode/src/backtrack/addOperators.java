package backtrack;

import java.util.ArrayList;
import java.util.List;

//给定一个仅包含数字0-9的字符串num和一个目标值整数target，在num的数字之间
//添加二元运算符（不是一元）+、-或*，返回所有能够得到目标值的表达式。
public class addOperators {
    String num;
    int n;
    int target;
    List<String>ans;
    public List<String> addOperators(String num, int target){
        this.n=num.length();
        this.num=num;
        this.target=target;
        this.ans=new ArrayList<String>();
        StringBuffer expr=new StringBuffer();
        backtrack(expr,0,0,0);
        return ans;
    }

    public void backtrack(StringBuffer expr,int idx,long res,long mul){
        if(idx==n){
            if(res==target)
                ans.add(expr.toString());
            System.out.println(expr.toString());
            return;
        }
        int signIdx=expr.length();
        if(idx>0)
            expr.append(0);
        long val=0;
        for(int j=idx;j<n&&(j==idx||num.charAt(idx)!='0');j++){
            val=val*10+num.charAt(j)-'0';
            expr.append(num.charAt(j));
            if(idx==0)
                backtrack(expr,j+1,val,val);
            else{
                expr.setCharAt(signIdx,'+');
                backtrack(expr,j+1,res+val,val);
                expr.setCharAt(signIdx,'-');
                backtrack(expr,j+1,res-val,-val);
                expr.setCharAt(signIdx,'*');
                backtrack(expr,j+1,res-mul+mul*val,mul*val);
            }
        }
        expr.setLength(signIdx);
    }

    public static void main(String[] args) {
        String num="239";
        int target=21;
        addOperators solution=new addOperators();
        System.out.println(solution.addOperators(num,target));
    }

}
