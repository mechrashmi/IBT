import java.util.ArrayList;

/**
 * Created by rashmimech on 1/13/17.
 */
public class Switchingulbs {
    public static void main(String[] args) {
        Switchingulbs test = new Switchingulbs();
        ArrayList<Integer> input = new ArrayList<>();
        input.add(1);
        input.add(1);
        input.add(1);
        input.add(0);
        input.add(0);
        input.add(0);
        input.add(1);
        input.add(1);
        input.add(0);
        System.out.println(test.bulbs(input));

    }

    public int bulbs(ArrayList<Integer> a) {
        int press = 0;
        boolean anyZero = false;
        int last = 0;
        for(int i = 0; i < a.size(); i++){
            if(!anyZero && a.get(i) == 0){
                press++;
                anyZero = true;
                last = 0;
                continue;
            }

            if(anyZero && a.get(i) != last){
                press++;
                last = a.get(i);
            }
        }

        return press;
    }

}
