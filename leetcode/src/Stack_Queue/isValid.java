package Stack_Queue;
import java.util.*;
public class isValid {
    public boolean isValid(String s) {
        int len=s.length();
        if(len%2==1)
            return false;
        Map<Character,Character>map=new HashMap<>(){{
            put(')','(');
            put(']','[');
            put('}', '{');
        }
        };
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<len;i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                if(stack.isEmpty()||stack.peek()!=map.get(ch))
                    return false;
                stack.pop();
            }else
                stack.push(ch);
        }
        return stack.isEmpty();

    }
}
