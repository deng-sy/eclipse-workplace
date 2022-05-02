package Nums_String;
import javax.swing.text.DefaultEditorKit;
import java.util.*;
//给定一个整数数组?temperatures?，表示每天的温度，返回一个数组?answer?，其中?answer[i]?是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用?0 来代替。

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

    public static void main(String[] args) {
        int[]temperatures={73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
}
