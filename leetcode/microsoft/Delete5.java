package microsoft;

public class Delete5 {
    public int solution(int N) {
        boolean pos = N > 0;
        int n = Math.abs(N);
        StringBuilder sb = new StringBuilder(String.valueOf(n));
        if (!pos) {
            for (int i = sb.length() - 1; i >= 0; i--) {
                if (sb.charAt(i) == '5') {
                    sb.deleteCharAt(i);
                    break;
                }
            }
        } else {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '5') {
                    sb.deleteCharAt(i);
                    break;
                }
            }
        }
        int sign = pos ? 1 : -1;
        return sign * Integer.valueOf(sb.toString());

    }

    public static void main(String[] args) {
        System.out.println(new Delete5().solution(-5859));
    }
}
