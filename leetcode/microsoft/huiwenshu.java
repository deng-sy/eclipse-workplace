package microsoft;


public class huiwenshu {
    public String solution(String S) {
        if (S.length() == 0)
            return "";
        int[] bits = new int[10];
        for (char ch : S.toCharArray()) {
            bits[ch - '0']++;
        }
        char single = 0;
        StringBuilder sb = new StringBuilder();
        boolean AtLeastOneNonZero = false;
        boolean ContainsNonZero = false;
        for (int i = 0; i < 10; i++) {
            int cnt = bits[i];
            if (cnt == 0)
                continue;
            if (!AtLeastOneNonZero && i > 0 && cnt > 1)
                AtLeastOneNonZero = true;
            if (!ContainsNonZero && i > 0)
                ContainsNonZero = true;
            if (cnt % 2 != 0)
                single = (char) ('0' + i);
            while (cnt > 1) {
                sb.append((char) ('0' + i));
                cnt -= 2;
            }
        }

        if (AtLeastOneNonZero) {
            if (single != 0)
                return sb.reverse().toString() + single + sb.reverse().toString();
            else
                return sb.reverse().toString() + sb.reverse().toString();
        } else {
            if (ContainsNonZero)
                return String.valueOf(single);
            else
                return "0";
        }
    }

    public static void main(String[] args) {
        String S = "12332910000";
        System.out.println(new huiwenshu().solution(S));
    }
}
