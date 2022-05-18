package programmers;

public class Q68935 {
    public static void main(String[] args) {
        System.out.println(solution(125));
    }

    public static int solution(int n) {
        String str3 = make3(n);
        return cal3Reversely(str3);
    }

    public static String make3(int n){
        StringBuilder sb = new StringBuilder();
        int q = n;
        int r = 0;

        while (q >= 3){
            q = n/3;
            r = n%3;
            n = q;
            sb.append(r);
        }
        sb.append(q);
        sb.reverse();
        return sb.toString();
    }

    public static int cal3Reversely(String n){
        double sum = 0;

        for (int i = 0 ; i < n.length() ; i++) {
            sum += (n.charAt(i) - '0') * Math.pow(3,i);
        }
        return (int)sum;
    }
}
