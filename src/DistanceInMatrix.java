import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by rashmimech on 2/19/17.
 */
public class DistanceInMatrix {
    public static void main(String[] args) {
        DistanceInMatrix tester = new DistanceInMatrix();
        Integer[] XArr = new Integer[]{-7, -13};
        Integer[] YArr = new Integer[]{1, -5};
        ArrayList<Integer> X = new ArrayList<>(Arrays.asList(XArr));
        ArrayList<Integer> Y = new ArrayList<>(Arrays.asList(YArr));
        System.out.println(tester.coverPoints(X, Y));
    }

    public int coverPoints(ArrayList<Integer> X, ArrayList<Integer> Y) {
        int dist = 0;
        int x1 = X.get(0);
        int y1 = Y.get(0);
        for(int i = 1; i < X.size(); i++){
            int x2 = X.get(i);
            int y2 = Y.get(i);

            int currDist = (int) Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

            dist += currDist;
            x1 = x2;
            y1 = y2;

        }

        return dist;

    }
}
