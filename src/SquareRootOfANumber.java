/**
 * Created by rashmimech on 2/14/17.
 */
public class SquareRootOfANumber {
    public static void main(String[] args) {
        SquareRootOfANumber tester = new SquareRootOfANumber();
        System.out.println(tester.sqrt(5));
    }
    public int sqrt(int a) {
        if(a == 0) return 0;
        if( a == 1) return 1;
        int l =  0; int h = a;
        int m = (l + (h - l))/2;
        while(l <= h){
            if( m == a / m )
                return m;

            if(m < a/m){
                l = m + 1;
            }
            else if(m > a/m){
                h = m - 1;
            }
            m = (l + h)/2;
        }

        return m;
    }
}
