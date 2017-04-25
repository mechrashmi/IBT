import java.util.ArrayList;

/**
 * Created by rashmimech on 1/29/17.
 */
public class Permutation {
    public static void main(String[] args) {
        Permutation tester = new Permutation();
        System.out.println(tester.findPerm("DD", 3));
    }
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> store = new ArrayList<Integer>();
        for(int i = 1; i <= B; i++){
            store.add(i);
        }

        int s = 0; int l = B - 1;
        ArrayList<Integer> res = new ArrayList<Integer>();
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == 'I'){
                res.add(store.get(s));
                store.remove(s);
            }
            else
            {
                res.add(store.get(l));
                store.remove(l);
            }
            l = store.size() - 1;
        }
        res.add(store.get(0));
        return res;
    }
}
