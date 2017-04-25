import java.util.ArrayList;

/**
 * Created by rashmimech on 1/30/17.
 */
public class Flip {
    public static void main(String[] args) {
        Flip tester = new Flip();
        System.out.println(tester.flip("010"));
    }

    public ArrayList<Integer> flip(String A) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int mClust = 0; int clus = 0;
        int mL = 0, mR = 0,L = 0, R = 0, firstZero = -1, lastZero = -1;
        int ones = 0; Boolean lastOne = true; Boolean firstzero = false;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '1'){
                ones++;
                if(!lastOne){
                    clus = (R - L) + 1;
                    if(mClust < clus){
                        mClust = clus;
                        mL = L;
                        mR = R;
                    }
                }
                L = i + 1;
                R = i + 1;
                lastOne = true;
            }
            else {
                if(!firstzero){
                    firstZero = i;
                    firstzero = true;
                }
                R = i;
                lastOne = false;
            }
        }

        if(L < R && R == A.length()){
            clus = R - L;
            if(mClust < clus){
                mL = L;
                mR = R;
            }
        }

        lastZero = R - 1;
        if(ones == A.length()) return res;

        int zero = A.length() - ones;

        if(zero > ones){
            res.add(firstZero + 1);
            res.add(lastZero + 1);
        }
        else{
            res.add(mL + 1);
            res.add(mR + 1);
        }

        return res;
    }
}
