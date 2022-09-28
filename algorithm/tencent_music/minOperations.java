package tencent_music;

public class minOperations {
    public int minOperations(String str) {
        // write code here
        int op1 = 0, op2 = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1')
                continue;
            op1++;
            i++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0')
                continue;
            op2++;
            i++;
        }
        return Math.min(op1, op2);
    }
}
