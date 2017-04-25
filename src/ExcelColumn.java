/**
 * Created by rashmimech on 2/9/17.
 */
public class ExcelColumn {
    public static void main(String[] args) {
        ExcelColumn tester = new ExcelColumn();

        System.out.println(tester.titleToNumber("AA"));

        System.out.println(tester.convertToTitle(943566));
    }
    public int titleToNumber(String a) {
        int n = a.length();
        int res = 0;
        for(int i = n - 1; i >= 0; i--){
            res += Math.pow(26, (n - 1) - i) * (a.charAt(i) - 'A' + 1);
        }

        return res;
    }


    public String convertToTitle(int a) {
        StringBuilder res = new StringBuilder();
        while(a > 0){
            int temp = (a - 1) % 26;
            res.append((char) ('A' + (temp)));
            a = (a - 1) / 26;
        }

        res.reverse();

        return res.toString();
    }
}
