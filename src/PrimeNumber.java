import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by rashmimech on 2/7/17.
 */
public class PrimeNumber {
    public static void main(String[] args) {
        PrimeNumber tester = new PrimeNumber();
        System.out.println(tester.primesum(4));
    }

    public ArrayList<Integer> primesum(int a) {
        ArrayList<Integer> res = new ArrayList<>();

        for(int i = 2; i <= a; i++){
            if(isPrime(i) && isPrime(a - i)){
                res.add(i);
                res.add(a - i);
                return res;
            }
        }
        return res;
    }

    public boolean isPrime(int num){
        for(int i = num; i <= Math.sqrt(num); i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public HashSet<Integer> seive(int p){
        ArrayList<Integer> primes = new ArrayList<>();

        for(int i = 0; i <= p; i++){
            primes.add(0);
        }

        for(int i = 2; i <= p; i++){
            //int last = (int) Math.sqrt(i);
            for(int j = 2; j <= p; j++){
                int val = i * j;
                if(val > p) break;

                primes.set(val, -1);
            }
        }

        HashSet<Integer> primesSet = new HashSet<>();

        for(int i = 2; i <= p; i++){
            if(primes.get(i).intValue() == 0){
                primesSet.add(i);
            }
        }

        return primesSet;
    }
}
