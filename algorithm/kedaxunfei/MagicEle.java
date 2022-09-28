package kedaxunfei;

import java.util.*;

public class MagicEle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String str = sc.nextLine();
            String[] inputs = str.split(" ");
            int n = inputs.length;
            int energy = Integer.parseInt(inputs[n - 1]);
            for (int i = 0; i < n - 1; i += 2) {
                String name = inputs[i];
                int cnt = Integer.parseInt(inputs[i + 1]);
            }
        }
    }
}
