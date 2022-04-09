package Nums_String;
import javax.swing.text.DefaultEditorKit;
import java.util.*;

public class dailyTemperatures {
    public static int[]dailyTemperatures(int[]temperatures){
        int len=temperatures.length;
        int[]res=new int[len];
        Deque<Integer>stack=new LinkedList<>();
        for(int i=0;i<len;i++){
            int temperature=temperatures[i];
            while(!stack.isEmpty()&&temperature>temperatures[stack.peek()]){
                int pre=stack.pop();
                res[pre]=i-pre;
            }
            stack.push(i);
        }
        return res;
    }
}
