package Nums_String;

public class addStrings {

    public static String addStrings(String num1, String num2) {
        int i=num1.length()-1,j=num2.length()-1;
        int add=0;
        StringBuffer sb=new StringBuffer();
        while(i>=0||j>=0||add!=0){
            int x=i>=0?num1.charAt(i)-'0':0;
            int y=j>=0?num2.charAt(j)-'0':0;
            int res=x+y+add;
            sb.append(res%10);
            add=res/10;
            i--;
            j--;
        }
        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("123","456"));
    }
}
