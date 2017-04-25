import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by rashmimech on 1/29/17.
 */
public class HotelBookings {
    public static void main(String[] args) {
        Integer[] arriveL = new Integer[]{1, 2, 3};
        Integer[] departL = new Integer[]{2, 3, 4};
        ArrayList<Integer> arrive = new ArrayList<Integer>(Arrays.asList(arriveL));
        ArrayList<Integer> depart = new ArrayList<Integer>(Arrays.asList(departL));
        HotelBookings test = new HotelBookings();
        System.out.println(test.hotel(arrive, depart, 2));

    }
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        int events = 1;

        Collections.sort(arrive);
        Collections.sort(depart);

        for(int j = 1, i = 0; j < arrive.size() || i < arrive.size(); ){
            if(j < arrive.size() && i < depart.size() - 1){
                if(arrive.get(j) <= depart.get(i)){
                   events++;
                   j++;
                }
                else{
                   events--;
                   i++;
                }
            }else if(j >= arrive.size() && i < depart.size()){
                events--;
                i++;
            }

            if(events > K) return false;
        }

        if(events > K) return false;

        return true;
    }
}
