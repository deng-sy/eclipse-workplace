package greedy;
//在一个平衡字符串中，'L'和'R'字符的数量是相同的。给你一个平衡字符串s，请你将它分割成尽可能多的平衡字符串。
public class balancedStringSplit {
    public static int balancedStringSplit(String str){
        int cnt=0,left=0,right=0;
        for(char ch:str.toCharArray()){
            if(ch=='L')
                left++;
            else
                right++;
            if(left==right)
                cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        String str="LRLLRLRR";
        System.out.println(balancedStringSplit(str));

    }
}
