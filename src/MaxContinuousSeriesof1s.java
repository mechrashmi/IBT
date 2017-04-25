import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by rashmimech on 2/24/17.
 */
public class MaxContinuousSeriesof1s {
    public static void main(String[] args) {
        //Integer[] list = new Integer[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        //Integer[] list = new Integer[]{0, 0, 1, 1, 0, 1, 1, 1, 1, 1 };
        Integer[] list = new Integer[]{1, 1, 0, 0, 0, 0, 0, 1};
        //Integer[] list = new Integer[]{0, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
        //Integer[] list = new Integer[]{0, 1, 1, 0, 1, 1, 1, 0, 0, 0 };
        //Integer[] list = new Integer[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1 };
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(list));

        System.out.println(new MaxContinuousSeriesof1s().maxone(arrayList, 4));
    }

    public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {
        ArrayList<Integer> res = new ArrayList<>();

        if(a.size() == 0) return res;


        int allowedFlip = b;
        int mL = -1;
        int mR = -1;
        int maxOnes = Integer.MIN_VALUE;
        int L = 0;
        int R = 0;
        int ones = 0;
        Map<Integer, Integer> flipPos = new HashMap<>();
        for(int i = 0; i < a.size(); i++){
            int val = a.get(i);

            if(val == 0 && allowedFlip > 0){
                flipPos.put(allowedFlip, i);
                allowedFlip--;
                ones++;
                //R++;
                continue;
            }

            if(val == 0 && allowedFlip == 0){
                if(maxOnes < ones){
                    mL = L;
                    mR = i - 1;
                    maxOnes = ones;
                }

                if(b == 0){
                    ones = 0;
                    L = i + 1;
                    continue;
                }

                ones = i - flipPos.get(b);
                L = flipPos.get(b) + 1;

                int pos = b;
                while(pos > 1){
                    flipPos.put(pos, flipPos.get(pos - 1));
                    pos--;
                }

                flipPos.put(1, i);
                //R = i;
                continue;
            }

            ones++;
        }

        if(maxOnes < ones && ones != 0){
            mL = L;
            mR = a.size() - 1;
        }

        if(mL == -1) return res;


        for(int i = mL; i <= mR; i++){
            res.add(i);
        }

        return  res;
    }
}
