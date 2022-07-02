package weilai;
import java.util.*;
public class legalHTML {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String str=in.next();
            if(check(str)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    private static boolean check(String str){
        Stack<String>stack=new Stack();
        int i=0;
        int n=str.length();
        while(i<n){
            char ch1=str.charAt(i);
            if(ch1=='<'){
                i++;
                if(i<n&&str.charAt(i)=='/'){
                    StringBuilder sb=new StringBuilder();
                    while(++i<n){
                        char ch2=str.charAt(i);
                        if(!Character.isLetter(ch2)){
                            if(ch2!='>')
                                return false;
                            break;
                        }

                        sb.append(ch2);
                    }
                    if(stack.isEmpty()||(!stack.pop().equals(sb.toString())))
                        return false;
                }else if(i<n&&Character.isLetter(str.charAt(i))){
                    StringBuilder sb=new StringBuilder();
                    while(i<n){
                        char ch2=str.charAt(i);
                        if(!Character.isLetter(ch2)){
                            if(ch2!='>')
                                return false;
                            break;
                        }
                        sb.append(ch2);
                        i++;
                    }
                    stack.push(sb.toString());
                }
            }else
                return false;
            i++;
        }
        return stack.isEmpty();
    }
}
