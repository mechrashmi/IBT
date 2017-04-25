import java.util.ArrayList;

/**
 * Created by rashmimech on 1/30/17.
 */
public class FirstMissingInteger {
    public static void main(String[] args) {

    }

    /*Store info in the same array*/
    public int firstMissingPositive(ArrayList<Integer> a) {
        int N = a.size();
        for(int i = 0; i < a.size(); i++){
            int num = a.get(i).intValue();
            if(num > 0 && num <= N){
                int pos = num - 1;
                if(a.get(pos).intValue() != a.get(i).intValue()){
                    int temp = a.get(pos).intValue();
                    a.set(pos, a.get(i));
                    a.set(i, temp);
                    i--;
                }
            }
        }

        for(int i = 0; i < a.size(); i++){
            if(a.get(i).intValue() != (i + 1)){
                return i + 1;
            }
        }

        return a.size() + 1;
    }
}
