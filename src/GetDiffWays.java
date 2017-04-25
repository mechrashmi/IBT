import java.util.Arrays;

/**
 * Created by rashmimech on 1/19/17.
 */
public class GetDiffWays {
    Integer[] dp;
    public static void main(String[] args) {
        GetDiffWays tester = new GetDiffWays();
        System.out.println(tester.numDecodings("5163490394499093221199401898020270545859326357520618953580237168826696965537789565062429676962877038781708385575876312877941367557410101383684194057405018861234394660905712238428675120866930196204792703765204322329401298924190"));
        System.out.println(tester.numDecodings("1222"));

    }
    public int numDecodings(String a) {
        if(a == null) return 0;
        StringBuilder sb = new StringBuilder(a);
        dp = new Integer[a.length()];
        Arrays.fill(dp, -1);
        int res = 1 + getDifWays(1, sb);
        dp[1] = res;
        return res;

    }

    public int getDifWays(int beg, StringBuilder a){
        if(beg >= a.length()) return 0;
        if(dp[beg] != -1) return dp[beg];
        int res = 0;
        for(int i = beg; i < a.length(); i++){
            
            int num = Integer.parseInt(a.charAt(i - 1) + "" + a.charAt(i));
            if(num <= 26){
                res += getDifWays(i + 2, a) + 1;
            }
        }
        dp[beg] = res;
        return res;
    }
}
