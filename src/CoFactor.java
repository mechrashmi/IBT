/**
 * Created by rashmimech on 2/12/17.
 */
public class CoFactor {
    public static void main(String[] args) {
        CoFactor tester = new CoFactor();
        System.out.println(tester.cpFact(90, 47));
    }
    public int cpFact(int A, int B) {

        while(findGCD(A,B) != 1){
            A /= findGCD(A, B);
        }

        return A;
    }

    public int findGCD(int a, int b){
        if(a == 0) return b;
        if(b == 0) return a;

        if(b > a)
            return findGCD(b % a, a);
        else
            return findGCD(a % b, b);
    }
}
