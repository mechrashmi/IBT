import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rashmimech on 3/29/17.


 Hamming distance between two non-negative integers is defined as the number of positions at which the corresponding bits are different.

 For example,

 HammingDistance(2, 7) = 2, as only the first and the third bit differs in the binary representation of 2 (010) and 7 (111).

 Given an array of N non-negative integers, find the sum of hamming distances of all pairs of integers in the array.
 Return the answer modulo 1000000007.

 Example

 Let f(x, y) be the hamming distance defined above.

 A=[2, 4, 6]

 We return,
 f(2, 2) + f(2, 4) + f(2, 6) +
 f(4, 2) + f(4, 4) + f(4, 6) +
 f(6, 2) + f(6, 4) + f(6, 6) =

 0 + 2 + 1
 2 + 0 + 1
 1 + 1 + 0 = 8

 */
public class PairWayshammingDistance {
    public static void main(String[] args) {
        Integer[] list = new Integer[]{2, 4, 6};
        ArrayList<Integer> arrayList = new ArrayList<>(Arrays.asList(list));

        System.out.println(new PairWayshammingDistance().hammingDistance(arrayList));
    }

    public int hammingDistance(final List<Integer> A) {
        int bitPosition;
        int sum = 0;
        for(bitPosition = 0; bitPosition < 31; bitPosition++){
            int bitCountZero = 0;
            int bitCountOne = 0;
            for(int i = 0; i < A.size(); i++){
                if((A.get(i) & (1 << bitPosition)) != 0) bitCountOne++;
                else
                    bitCountZero++;
            }
            sum += (2 * bitCountOne * bitCountZero) %  1000000007;

            if(sum >= 1000000007) sum = sum - 1000000007;
        }

        return sum;
    }
}
